package com.kangyonggan.bm.controller;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.bm.model.Api;
import com.kangyonggan.bm.model.ErrorCode;
import com.kangyonggan.bm.service.ApiService;
import com.kangyonggan.bm.service.ErrorCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author kangyonggan
 * @since 16/10/13
 */
@Controller
@RequestMapping("code")
public class ErrorCodeController {

    private static final String PATH_ROOT = "code/";
    private static final String PATH_LIST = PATH_ROOT + "list";
    private static final String PATH_FORM = PATH_ROOT + "form";

    @Autowired
    private ErrorCodeService errorCodeService;

    /**
     * 错误码管理
     *
     * @param pageNum
     * @param apiId
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                       @RequestParam(value = "apiId", required = false, defaultValue = "0") Long apiId,
                       Model model) {
        List<ErrorCode> errorCodes = errorCodeService.searchErrorCodes(pageNum, apiId);
        PageInfo<ErrorCode> page = new PageInfo(errorCodes);

        model.addAttribute("page", page);
        return PATH_LIST;
    }

    /**
     * 添加错误码
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("errorCode", new ErrorCode());
        return PATH_FORM;
    }

    /**
     * 保存错误码
     *
     * @param errorCode
     * @param result
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute("errorCode") @Valid ErrorCode errorCode,
                       BindingResult result) {
        if (!result.hasErrors()) {
            errorCodeService.saveErrorCode(errorCode);
            return "redirect:/" + PATH_ROOT;
        } else {
            return PATH_FORM;
        }
    }

    /**
     * 修改错误码
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model) {
        ErrorCode errorCode = errorCodeService.findErrorCodeById(id);

        model.addAttribute("errorCode", errorCode);
        return PATH_FORM;
    }

    /**
     * 更新错误码
     *
     * @param errorCode
     * @param result
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("errorCode") @Valid ErrorCode errorCode,
                       BindingResult result) {
        if (!result.hasErrors()) {
            errorCodeService.updateErrorCode(errorCode);
            return "redirect:/" + PATH_ROOT;
        } else {
            return PATH_FORM;
        }
    }

    /**
     * 删除错误码
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        ErrorCode errorCode = errorCodeService.findErrorCodeById(id);
        errorCodeService.deleteErrorCode(errorCode);

        return "redirect:/" + PATH_ROOT;
    }

    /**
     * 恢复错误码
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/recover", method = RequestMethod.GET)
    public String recover(@PathVariable("id") Long id) {
        ErrorCode errorCode = errorCodeService.findErrorCodeById(id);
        errorCodeService.recoverErrorCode(errorCode);

        return "redirect:/" + PATH_ROOT;
    }

}
