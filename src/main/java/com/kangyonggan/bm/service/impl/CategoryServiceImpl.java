package com.kangyonggan.bm.service.impl;

import com.github.pagehelper.PageHelper;
import com.kangyonggan.bm.constants.AppConstants;
import com.kangyonggan.bm.model.Category;
import com.kangyonggan.bm.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author kangyonggan
 * @since 16/10/13
 */
@Service
public class CategoryServiceImpl extends BaseService<Category> implements CategoryService {

    @CacheEvict(cacheNames = "category", allEntries = true)
    @Override
    public void saveCategory(Category category) {
        super.insertSelective(category);
    }

    @CacheEvict(cacheNames = "category", allEntries = true)
    @Override
    public void updateCategory(Category category) {
        super.updateByPrimaryKeySelective(category);
    }

    @CacheEvict(cacheNames = "category", allEntries = true)
    @Override
    public void deleteCategory(Category category) {
        category.setIsDeleted(AppConstants.IS_DELETED_YES);

        super.updateByPrimaryKeySelective(category);
    }

    @CacheEvict(cacheNames = "category", allEntries = true)
    @Override
    public void recoverCategory(Category category) {
        category.setUpdatedTime(new Date());
        category.setIsDeleted(AppConstants.IS_DELETED_NO);

        super.updateByPrimaryKeySelective(category);
    }

    @Override
    public Category findCategoryById(Long id) {
        return super.selectByPrimaryKey(id);
    }

    @Cacheable(value = "category", key = "'category_code_' + #categoryCode")
    @Override
    public Category findCategoryByCode(String categoryCode) {
        Category category = new Category();
        category.setIsDeleted(AppConstants.IS_DELETED_NO);
        category.setCode(categoryCode);

        return super.selectOne(category);
    }

    @Override
    public List<Category> searchCategories(int pageNum, String name) {
        Example example = new Example(Category.class);

        if (StringUtils.isNotEmpty(name)) {
            example.createCriteria().andLike("name", "%" + name + "%");
        }

        example.setOrderByClause("sort asc");

        PageHelper.startPage(pageNum, AppConstants.PAGE_SIZE);
        return super.selectByExample(example);
    }

    @Cacheable(value = "category", key = "'category_all'")
    @Override
    public List<Category> findAllCategories() {
        Category category = new Category();
        category.setIsDeleted(AppConstants.IS_DELETED_NO);

        return super.select(category);
    }
}
