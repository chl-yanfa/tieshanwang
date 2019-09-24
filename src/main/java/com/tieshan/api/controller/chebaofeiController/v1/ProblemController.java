package com.tieshan.api.controller.chebaofeiController.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientProblemBO;
import com.tieshan.api.common.chebaofeiCommon.PageResult;
import com.tieshan.api.common.chebaofeiCommon.ResultBean;
import com.tieshan.api.service.chebaofeiService.v1.ProblemService;
import com.tieshan.api.util.toolUtil.ClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/24 9:25
 */
@RestController
@RequestMapping("/carscraporder-applet/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 获取常见问题分页列表
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<PageResult<ClientProblemBO>> getProblemPageList(
           @RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(value = "rows", required = true, defaultValue = "10") Integer rows)
            throws Exception {
        ClientUtil.getUser();
        PageResult<ClientProblemBO> pageResult = null;
        PageInfo<ClientProblemBO> pageInfo = problemService.queryPageList(page, rows);
        if (pageInfo != null) {
            pageResult = new PageResult<>();
            pageResult.setRows(pageInfo.getList());
            pageResult.setTotal(pageInfo.getTotal());
        }
        return new ResultBean<>(pageResult);
    }

    /**
     * 根据id获取消息详情
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResultBean<ClientProblemBO> Message(@PathVariable("id") String id) throws Exception {
        return new ResultBean<>(problemService.queryBOById(id));
    }
}
