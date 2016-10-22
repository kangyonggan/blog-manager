package com.kangyonggan.bm.service.impl;

import com.github.pagehelper.PageHelper;
import com.kangyonggan.bm.constants.AppConstants;
import com.kangyonggan.bm.model.ErrorCode;
import com.kangyonggan.bm.service.ErrorCodeService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kangyonggan
 * @since 16/10/13
 */
@Service
public class ErrorCodeServiceImpl extends BaseService<ErrorCode> implements ErrorCodeService {

    @Override
    public void saveErrorCode(ErrorCode errorCode) {
        super.insertSelective(errorCode);
    }

    @Override
    public void updateErrorCode(ErrorCode errorCode) {
        super.updateByPrimaryKeySelective(errorCode);
    }

    @Override
    public void deleteErrorCode(ErrorCode errorCode) {
        errorCode.setIsDeleted(AppConstants.IS_DELETED_YES);

        super.updateByPrimaryKeySelective(errorCode);
    }

    @Override
    public void recoverErrorCode(ErrorCode errorCode) {
        errorCode.setIsDeleted(AppConstants.IS_DELETED_NO);

        super.updateByPrimaryKeySelective(errorCode);
    }

    @Override
    public ErrorCode findErrorCodeById(Long id) {
        return super.selectByPrimaryKey(id);
    }

    @Override
    public List<ErrorCode> searchErrorCodes(int pageNum, Long apiId) {
        Example example = new Example(ErrorCode.class);
        Example.Criteria criteria = example.createCriteria();

        if (apiId != 0) {
            criteria.andEqualTo("apiId", apiId);
        }

        example.setOrderByClause("id desc");

        PageHelper.startPage(pageNum, AppConstants.PAGE_SIZE);
        return super.selectByExample(example);
    }

}
