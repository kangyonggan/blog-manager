package com.kangyonggan.bm.controller;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.bm.model.Api;
import com.kangyonggan.bm.service.ApiService;
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
@RequestMapping("api")
public class ApiController {

    private static final String PATH_ROOT = "api/";
    private static final String PATH_LIST = PATH_ROOT + "list";
    private static final String PATH_FORM = PATH_ROOT + "form";

    @Autowired
    private ApiService apiService;

    /**
     * api管理
     *
     * @param pageNum
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                       @RequestParam(value = "name", required = false, defaultValue = "") String name,
                       Model model) {
        List<Api> apis = apiService.searchApis(pageNum, name);
        PageInfo<Api> page = new PageInfo(apis);

        model.addAttribute("page", page);
        return PATH_LIST;
    }

    /**
     * 添加api
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("api", new Api());
        return PATH_FORM;
    }

    /**
     * 保存api
     *
     * @param api
     * @param result
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute("api") @Valid Api api,
                       BindingResult result) {
        if (!result.hasErrors()) {
            apiService.saveApi(api);
            return "redirect:/" + PATH_ROOT;
        } else {
            return PATH_FORM;
        }
    }

    /**
     * 修改api
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model) {
        Api api = apiService.findApiById(id);

        model.addAttribute("api", api);
        return PATH_FORM;
    }

    /**
     * 更新api
     *
     * @param api
     * @param result
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("api") @Valid Api api,
                       BindingResult result) {
        if (!result.hasErrors()) {
            apiService.updateApi(api);
            return "redirect:/" + PATH_ROOT;
        } else {
            return PATH_FORM;
        }
    }

    /**
     * 删除api
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        Api api = apiService.findApiById(id);
        apiService.deleteApi(api);

        return "redirect:/" + PATH_ROOT;
    }

    /**
     * 恢复api
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/recover", method = RequestMethod.GET)
    public String recover(@PathVariable("id") Long id) {
        Api api = apiService.findApiById(id);
        apiService.recoverApi(api);

        return "redirect:/" + PATH_ROOT;
    }

}
