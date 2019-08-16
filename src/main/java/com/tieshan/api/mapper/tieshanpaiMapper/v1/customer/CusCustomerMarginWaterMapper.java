package com.tieshan.api.mapper.tieshanpaiMapper.v1.customer;

import com.tieshan.api.po.tieshanpaiPo.v1.customer.CusCustomerMarginWater;
import org.springframework.stereotype.Repository;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 17:51
 */
@Repository
public interface CusCustomerMarginWaterMapper {
    int createCusCustomerMarginWater(CusCustomerMarginWater cusCustomerMarginWater);
}
