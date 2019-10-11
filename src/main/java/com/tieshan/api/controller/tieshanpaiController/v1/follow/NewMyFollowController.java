package com.tieshan.api.controller.tieshanpaiController.v1.follow;

import com.tieshan.api.common.chebaofeiCommon.Exception.DataException;
import com.tieshan.api.po.homePagePo.v1.TbArticle;
import com.tieshan.api.po.tieshanpaiPo.v1.follow.FollowSelect;
import com.tieshan.api.po.tieshanpaiPo.v1.follow.NewMyFollow;
import com.tieshan.api.service.tieshanpaiService.v1.follow.NewMyFollowService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import com.tieshan.api.util.toolUtil.ClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "v1/follow/")
public class NewMyFollowController {
    @Autowired
    private NewMyFollowService newMyFollowService;
    @RequestMapping(value = "insertNewMyFollow",method = RequestMethod.POST)
    public ApiResult insertNewMyFollow(HttpServletRequest request, NewMyFollow newMyFollow) throws DataException {
        newMyFollow.setUserId(ClientUtil.getUser().getId());
        newMyFollow.setCreateTime(new Date());
        newMyFollow.setUpdateTime(new Date());
        int num=newMyFollowService.insertSelective(newMyFollow);
        if(num>0){
           return ResultUtil.success("新增成功");
        }
        return ResultUtil.error(501,"新增失败");
    }
    @RequestMapping(value = "deleteNewMyFollow",method = RequestMethod.DELETE)
    public ApiResult deleteNewMyFollow(HttpServletRequest request) throws DataException {
        String id=request.getParameter("id");
        int num=newMyFollowService.delete(Integer.parseInt(id));
        if(num>0){
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.error(501,"删除失败");
    }
    @RequestMapping("/selectNewMyFollow")
    public ApiResult selectNewMyFollow(HttpServletRequest request, Map map) throws DataException {
        map.put("userId",ClientUtil.getUser().getId());
        List<NewMyFollow>list =newMyFollowService.selectMap(map);
        List<FollowSelect>lists =new ArrayList<>();
        for (NewMyFollow newMyFollow : list) {
            FollowSelect followSelect=newMyFollowService.select(newMyFollow.getTypeId());
            followSelect.setId(newMyFollow.getId());
            lists.add(followSelect);
        }
        return  ResultUtil.success(lists);
    }
}
