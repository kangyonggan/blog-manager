package com.kangyonggan.bm.service;

import com.kangyonggan.bm.model.Chapter;

/**
 * @author kangyonggan
 * @since 16/10/13
 */
public interface ChapterService {

    /**
     * 保存章节
     *
     * @param chapter
     */
    void saveChapter(Chapter chapter);

    /**
     * 查找最后一章
     *
     * @param code
     * @return
     */
    Chapter findLastChapter(String code);
}
