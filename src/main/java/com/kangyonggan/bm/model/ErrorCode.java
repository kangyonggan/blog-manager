package com.kangyonggan.bm.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "error_code")
@Data
public class ErrorCode {
    /**
     * 主键, 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * api id
     */
    @Column(name = "api_id")
    private Long apiId;

    /**
     * api错误码
     */
    @Column(name = "api_error_code")
    private String apiErrorCode;

    /**
     * api错误描述
     */
    @Column(name = "api_error_desc")
    private String apiErrorDesc;

    /**
     * 内部错误码
     */
    @Column(name = "error_code")
    private String errorCode;

    /**
     * 内部错误描述
     */
    @Column(name = "error_desc")
    private String errorDesc;

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
}