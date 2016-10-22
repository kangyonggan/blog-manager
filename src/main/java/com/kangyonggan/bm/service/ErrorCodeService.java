package com.kangyonggan.bm.service;

import com.kangyonggan.bm.model.ErrorCode;

import java.util.List;

/**
 * @author kangyonggan
 * @since 16/10/13
 */
public interface ErrorCodeService {

    /**
     * 保存错误码
     *
     * @param errorCode
     */
    void saveErrorCode(ErrorCode errorCode);

    /**
     * 更新错误码
     *
     * @param errorCode
     */
    void updateErrorCode(ErrorCode errorCode);

    /**
     * 删除错误码
     *
     * @param errorCode
     */
    void deleteErrorCode(ErrorCode errorCode);

    /**
     * 恢复错误码
     *
     * @param errorCode
     */
    void recoverErrorCode(ErrorCode errorCode);

    /**
     * 根据ID查找错误码
     *
     * @param id
     * @return
     */
    ErrorCode findErrorCodeById(Long id);

    /**
     * 搜索错误码
     *
     * @param pageNum
     * @param apiId
     * @return
     */
    List<ErrorCode> searchErrorCodes(int pageNum, Long apiId);
}
