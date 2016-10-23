package com.kangyonggan.bm.controller;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.bm.model.ApiCommand;
import com.kangyonggan.bm.service.ApiCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kangyonggan
 * @since 16/10/13
 */
@Controller
@RequestMapping("command")
public class ApiCommandController {

    private static final String PATH_ROOT = "command/";
    private static final String PATH_LIST = PATH_ROOT + "list";

    @Autowired
    private ApiCommandService apiCommandService;

    /**
     * api管理
     *
     * @param pageNum
     * @param apiCode
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                       @RequestParam(value = "apiCode", required = false, defaultValue = "") String apiCode,
                       Model model) {
        List<ApiCommand> commands = apiCommandService.searchApiCommands(pageNum, apiCode);
        PageInfo<ApiCommand> page = new PageInfo(commands);

        model.addAttribute("page", page);
        return PATH_LIST;
    }

}
