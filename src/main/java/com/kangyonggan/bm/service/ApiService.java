package com.kangyonggan.bm.service;

import com.kangyonggan.bm.model.Api;

import java.util.List;

/**
 * @author kangyonggan
 * @since 16/10/13
 */
public interface ApiService {

    /**
     * 保存api
     *
     * @param api
     */
    void saveApi(Api api);

    /**
     * 更新api
     *
     * @param api
     */
    void updateApi(Api api);

    /**
     * 删除api
     *
     * @param api
     */
    void deleteApi(Api api);

    /**
     * 恢复api
     *
     * @param api
     */
    void recoverApi(Api api);

    /**
     * 根据ID查找api
     *
     * @param id
     * @return
     */
    Api findApiById(Long id);

    /**
     * 搜索api
     *
     * @param pageNum
     * @param name
     * @return
     */
    List<Api> searchApis(int pageNum, String name);
}
