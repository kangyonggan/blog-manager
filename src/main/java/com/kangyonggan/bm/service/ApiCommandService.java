package com.kangyonggan.bm.service;

import com.kangyonggan.bm.model.Api;
import com.kangyonggan.bm.model.ApiCommand;

import java.util.List;

/**
 * @author kangyonggan
 * @since 16/10/13
 */
public interface ApiCommandService {

    /**
     * 搜索api指令
     *
     * @param pageNum
     * @param apiCode
     * @return
     */
    List<ApiCommand> searchApiCommands(int pageNum, String apiCode);
}
