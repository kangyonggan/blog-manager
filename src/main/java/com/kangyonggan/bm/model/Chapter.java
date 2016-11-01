package com.kangyonggan.bm.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
public class Chapter {
    /**
     * 主键, 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 书代码
     */
    @Column(name = "book_code")
    private String bookCode;

    /**
     * 书名称
     */
    @Column(name = "book_name")
    private String bookName;

    /**
     * 章节名称
     */
    private String title;

    /**
     * 章节序号
     */
    @Column(name = "chapter_no")
    private Integer chapterNo;

    /**
     * 是否删除 {0:未删除, 1:已删除}
     */
    @Column(name = "is_deleted")
    private Byte isDeleted;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 最后更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 内容
     */
    private String body;
}