package com.tieshan.api.controller.tieshanpaiController.v1.category;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.common.chebaofeiCommon.PageResult;
import com.tieshan.api.common.chebaofeiCommon.ResultBean;
import com.tieshan.api.po.chebaofeiPo.v1.TbCarParts;
import com.tieshan.api.po.chebaofeiPo.v1.TbCarPartsCategory;
import com.tieshan.api.service.chebaofeiService.v1.TbCarPartsCategoryService;
import com.tieshan.api.service.chebaofeiService.v1.TbCarPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** 获取配件分类
 * @author ningrz
 * @version 1.0
 * @date 2019/10/9 13:16
 */
@RequestMapping(value="/carPartsCategory")
@CrossOrigin
@RestController
public class getCategoryController {

    @Autowired
    private TbCarPartsCategoryService tbCarPartsCategoryService;

    @Autowired
    private TbCarPartsService tbCarPartsService;

    @RequestMapping(value="list",method = RequestMethod.GET)
    public ResultBean<PageResult> getCarPartsCategoryPageList(
            @RequestParam(value="page",defaultValue="1")Integer page,
            @RequestParam(value="rows",defaultValue="10")Integer rows, TbCarPartsCategory param) throws Exception{

        PageResult pageResult  = new PageResult();
        PageInfo<TbCarPartsCategory> pageInfo =  tbCarPartsCategoryService.queryMyPageListByWhere(page,rows,param);
        pageResult.setRows(pageInfo.getList());
        pageResult.setTotal(pageInfo.getTotal());
        return new ResultBean(pageResult);
    }

    @RequestMapping(value="getCarParts",method = RequestMethod.GET)
    public ResultBean<PageResult> getCarPartsByCategoryId(
            @RequestParam(value="page",defaultValue="1")Integer page,
            @RequestParam(value="rows",defaultValue="10")Integer rows,
            TbCarParts param) throws Exception{
        PageResult pageResult  = new PageResult();
        PageInfo<TbCarParts> pageInfo =  tbCarPartsService.queryByIdPageListByWhere(page,rows,param);
        pageResult.setRows(pageInfo.getList());
        pageResult.setTotal(pageInfo.getTotal());
        return new ResultBean(pageResult);
    }
}
