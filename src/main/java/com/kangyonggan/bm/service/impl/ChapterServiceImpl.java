package com.kangyonggan.bm.service.impl;

import com.github.pagehelper.PageHelper;
import com.kangyonggan.bm.constants.AppConstants;
import com.kangyonggan.bm.model.Chapter;
import com.kangyonggan.bm.service.ChapterService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2016/11/1
 */
@Service
public class ChapterServiceImpl extends BaseService<Chapter> implements ChapterService {

    @Override
    public void saveChapter(Chapter chapter) {
        super.insertSelective(chapter);
    }

    @Override
    public Chapter findLastChapter(String code) {
        Example example = new Example(Chapter.class);
        example.createCriteria().andEqualTo("bookCode", code).andEqualTo("isDeleted", AppConstants.IS_DELETED_NO);
        example.setOrderByClause("chapter_no desc");

        PageHelper.startPage(1, 1);
        List<Chapter> chapters = super.selectByExample(example);
        return chapters == null || chapters.isEmpty() ? null : chapters.get(0);
    }
}
