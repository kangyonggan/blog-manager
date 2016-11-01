package com.kangyonggan.bm.service.impl;

import com.kangyonggan.bm.model.Chapter;
import com.kangyonggan.bm.service.ChapterService;
import org.springframework.stereotype.Service;

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
}
