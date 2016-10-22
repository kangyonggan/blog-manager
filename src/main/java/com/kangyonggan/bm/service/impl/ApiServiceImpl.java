package com.kangyonggan.bm.service.impl;

import com.github.pagehelper.PageHelper;
import com.kangyonggan.bm.constants.AppConstants;
import com.kangyonggan.bm.model.Api;
import com.kangyonggan.bm.service.ApiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kangyonggan
 * @since 16/10/13
 */
@Service
public class ApiServiceImpl extends BaseService<Api> implements ApiService {

    @Override
    public void saveApi(Api api) {
        super.insertSelective(api);
    }

    @Override
    public void updateApi(Api api) {
        super.updateByPrimaryKeySelective(api);
    }

    @Override
    public void deleteApi(Api api) {
        api.setIsDeleted(AppConstants.IS_DELETED_YES);

        super.updateByPrimaryKeySelective(api);
    }

    @Override
    public void recoverApi(Api api) {
        api.setIsDeleted(AppConstants.IS_DELETED_NO);

        super.updateByPrimaryKeySelective(api);
    }

    @Override
    public Api findApiById(Long id) {
        return super.selectByPrimaryKey(id);
    }

    @Override
    public List<Api> searchApis(int pageNum, String name) {
        Example example = new Example(Api.class);
        Example.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }

        example.setOrderByClause("id desc");

        PageHelper.startPage(pageNum, AppConstants.PAGE_SIZE);
        return super.selectByExample(example);
    }

}
