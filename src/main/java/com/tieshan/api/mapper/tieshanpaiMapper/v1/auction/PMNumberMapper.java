package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.PMNumber;
import org.springframework.stereotype.Repository;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/10/8 13:37
 */
@Repository
public interface PMNumberMapper {

    PMNumber getPMNumberByType(Integer type);

    int updatePMNumberById(Integer id);
}
