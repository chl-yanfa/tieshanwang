package com.tieshan.api.mapper.chegujiaMapper;

import com.tieshan.api.po.chegujiaPo.TieshangjCarRegionalArtificial;
import org.apache.ibatis.annotations.Param;

public interface TieshangjCarRegionalArtificialMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TieshangjCarRegionalArtificial record);

    TieshangjCarRegionalArtificial selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarRegionalArtificial record);
    //根据车型铁码查询在某个省份的人工调整值
    String selectArtifi(@Param("tiema") String tiema, @Param("pid") String pid);

}