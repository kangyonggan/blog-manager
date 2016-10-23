package com.kangyonggan.bm.service.impl;

import com.github.pagehelper.PageHelper;
import com.kangyonggan.bm.constants.AppConstants;
import com.kangyonggan.bm.model.Api;
import com.kangyonggan.bm.model.ApiCommand;
import com.kangyonggan.bm.service.ApiCommandService;
import com.kangyonggan.bm.service.ApiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kangyonggan
 * @since 16/10/13
 */
@Service
public class ApiCommandServiceImpl extends BaseService<ApiCommand> implements ApiCommandService {

    @Override
    public List<ApiCommand> searchApiCommands(int pageNum, String apiCode) {
        Example example = new Example(ApiCommand.class);
        Example.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(apiCode)) {
            criteria.andEqualTo("apiCode", apiCode);
        }

        example.setOrderByClause("id desc");

        PageHelper.startPage(pageNum, AppConstants.PAGE_SIZE);
        return super.selectByExample(example);
    }

}
