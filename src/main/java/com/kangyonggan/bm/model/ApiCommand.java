package com.kangyonggan.bm.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Table(name = "api_command")
@Data
public class ApiCommand {
    /**
     * 主键, 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * api代码
     */
    @Column(name = "api_code")
    private String apiCode;

    /**
     * 参数串
     */
    private String params;

    /**
     * 指令状态,{I:处理中,F:失败,E:异常,Y:成功}
     */
    private String status;

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
     * 参数串
     */
    private String result;
}