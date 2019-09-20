package com.tieshan.api.service.chebaofeiService.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.UserBO;
import com.tieshan.api.bo.chebaofeiBo.v1.UserSimpleBO;
import com.tieshan.api.po.chebaofeiPo.v1.User;
import com.tieshan.api.service.BaseService;
import com.tieshan.api.vo.chebaofeiVo.v1.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:49
 */
public interface UserService extends BaseService<User> {
    Integer saveUserAndRoleAndAreas(UserVO uservo)throws Exception;

    Integer updateUserAndRoleAndAreas(UserVO uservo)throws Exception;

    Integer deleteById(String id)throws Exception;

    UserBO queryUserBOById(String id)throws Exception;

    User queryById(String id)throws Exception;

    PageInfo<UserBO> queryPageListUser(Integer page, Integer rows, UserVO user) throws Exception;

    UserBO queryUserBOByName(String loginname)throws Exception;

    List<UserSimpleBO> getReceiveOrderPermissionUser(String permisscode, String areid);

    List<UserSimpleBO> getAllMoneyPeople(Integer roleNum);

    List<UserSimpleBO> getAllBussinessPeople(@Param("permisscode")String permisscode);
}
