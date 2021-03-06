package com.guigu.instructional.marketactive.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveExample;

public interface MarketActiveMapper {
    int countByExample(MarketActiveExample example);

    int deleteByExample(MarketActiveExample example);

    int deleteByPrimaryKey(Integer activeId);

    int insert(MarketActive record);

    int insertSelective(MarketActive record);

    List<MarketActive> selectByExample(MarketActiveExample example);

    MarketActive selectByPrimaryKey(Integer activeId);

    int updateByExampleSelective(@Param("record") MarketActive record, @Param("example") MarketActiveExample example);

    int updateByExample(@Param("record") MarketActive record, @Param("example") MarketActiveExample example);

    int updateByPrimaryKeySelective(MarketActive record);

    int updateByPrimaryKey(MarketActive record);
}