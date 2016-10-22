package com.kangyonggan.bm.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Api {
    /**
     * 主键, 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * api名称
     */
    private String name;

    /**
     * api描述
     */
    private String description;

    /**
     * api地址
     */
    private String url;

    /**
     * api请求方式
     */
    private String method;

    /**
     * 错误码字段名称
     */
    @Column(name = "error_name")
    private String errorName;

    /**
     * 错误码描述字段名称
     */
    @Column(name = "error_msg_name")
    private String errorMsgName;

    /**
     * 数据名称
     */
    @Column(name = "data_name")
    private String dataName;

    /**
     * 字段描述
     */
    @Column(name = "data_desc")
    private String dataDesc;

    /**
     * 字段
     */
    private String data;

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