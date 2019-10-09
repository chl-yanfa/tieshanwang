package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAuctionFile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarPmAuctionFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPmAuctionFile record);

    int insertSelective(CarPmAuctionFile record);

    CarPmAuctionFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPmAuctionFile record);

    int updateByPrimaryKey(CarPmAuctionFile record);

    int addAuctionFileBatch(List<CarPmAuctionFile> list);
}