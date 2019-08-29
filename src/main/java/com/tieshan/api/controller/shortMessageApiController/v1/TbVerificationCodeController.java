package com.tieshan.api.controller.shortMessageApiController.v1;

import com.tieshan.api.po.shortMessageApiPo.v1.TbVerificationCode;
import com.tieshan.api.service.shortMessageApiService.v1.TbVerificationCodeService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "v1/vercode/")
public class TbVerificationCodeController {
    @Autowired
    private TbVerificationCodeService tbVerificationCodeService;
    //验证码验证
    @RequestMapping(value = "verification",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult verification(HttpServletRequest request){
        String phone=request.getParameter("phone");
        String yType=request.getParameter("yType");//验证码类型
        String code=request.getParameter("vecode");//验证码
        String validateCodeByDB=tbVerificationCodeService.getValidateCode(phone,yType);
        if(StringUtils.isNotBlank(validateCodeByDB)){
            if(!validateCodeByDB.equals(code)){
                return ResultUtil.error(500,"验证码错误");
            }
            return ResultUtil.success("验证成功");
        }
        return ResultUtil.error(500,"验证码错误");
    }
    //获取验证码
    @RequestMapping(value = "getValidateCode",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult getValidateCode(HttpServletRequest request, TbVerificationCode tbVerificationCode)throws Exception{
        String phone=request.getParameter("phone");
        String type=request.getParameter("type");
        tbVerificationCode.setPhone(phone);
        tbVerificationCode.setType(Integer.parseInt(type));
        int num=tbVerificationCodeService.insertSelective(tbVerificationCode);
        if(num>0){
            return ResultUtil.success("请求成功");
        }
        return ResultUtil.error(500,"系统错误");
    }
}
