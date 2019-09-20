package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.bo.chebaofeiBo.v1.UserBO;
import com.tieshan.api.bo.chebaofeiBo.v1.UserSimpleBO;
import com.tieshan.api.po.chebaofeiPo.v1.User;
import com.tieshan.api.vo.chebaofeiVo.v1.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 9:57
 */
@Repository
public interface UserMapper extends Mapper<User> {

    UserBO queryUserBOById(String id);

    List<UserBO> queryPageUser(UserVO paramter);

    UserBO queryUserBOByNameAndPassword(String loginname);

    List<UserSimpleBO> getReceiveOrderPermissionUser(@Param("permisscode")String permisscode, @Param("areid")String areid);

    List<UserSimpleBO> getAllBussinessPeople(@Param("permisscode")String permisscode);

    List<UserSimpleBO> getAllMoneyPeople(@Param("roleid")Integer roleNum);
}
