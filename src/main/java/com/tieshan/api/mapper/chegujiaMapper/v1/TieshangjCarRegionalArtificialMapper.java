package com.tieshan.api.mapper.chegujiaMapper.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarRegionalArtificial;
import org.apache.ibatis.annotations.Param;

public interface TieshangjCarRegionalArtificialMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TieshangjCarRegionalArtificial record);

    TieshangjCarRegionalArtificial selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarRegionalArtificial record);
    //根据车型铁码查询在某个省份的人工调整值
    String selectArtifi(@Param("tiema") String tiema, @Param("pid") String pid);
    //根据车组id查询在某个省份的人工调整值
    String selectArtifi2(@Param("ctid") String ctid, @Param("pid") String pid);

}