package com.tieshan.api.controller.chebaofeiController.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientMessageBO;
import com.tieshan.api.common.chebaofeiCommon.PageResult;
import com.tieshan.api.common.chebaofeiCommon.ResultBean;
import com.tieshan.api.service.chebaofeiService.v1.MessageService;
import com.tieshan.api.util.toolUtil.ClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/23 17:34
 */
@RestController
@RequestMapping(value="/carscraporder-applet/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 获取消息未读条数
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/unReadTotal",method = RequestMethod.GET)
    public ResultBean<Integer> getMessageUnReadTotal() throws Exception{
        String clientId = ClientUtil.getUser().getId();
        return new ResultBean<>(messageService.queryUnReadTotal(clientId));
    }


    /**
     * 获取消息分页列表
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<PageResult<ClientMessageBO>> getMessageList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer rows) throws Exception {
        ClientUtil.getUser();
        PageResult<ClientMessageBO> pageResult = null;
        PageInfo<ClientMessageBO> pageInfo = messageService.queryPageList(page, rows);
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
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResultBean<ClientMessageBO> getMessageById(@PathVariable("id")String id) throws Exception{
        return new ResultBean<>(messageService.queryBOById(id));
    }
}
