package com.guigu.instructional.system.mapper;

import com.guigu.instructional.po.RoleAnthortyInfo;
import com.guigu.instructional.po.RoleAnthortyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAnthortyInfoMapper {
    int countByExample(RoleAnthortyInfoExample example);

    int deleteByExample(RoleAnthortyInfoExample example);

    int deleteByPrimaryKey(Integer roleAnthortyId);

    int insert(RoleAnthortyInfo record);

    int insertSelective(RoleAnthortyInfo record);

    List<RoleAnthortyInfo> selectByExample(RoleAnthortyInfoExample example);

    RoleAnthortyInfo selectByPrimaryKey(Integer roleAnthortyId);

    int updateByExampleSelective(@Param("record") RoleAnthortyInfo record, @Param("example") RoleAnthortyInfoExample example);

    int updateByExample(@Param("record") RoleAnthortyInfo record, @Param("example") RoleAnthortyInfoExample example);

    int updateByPrimaryKeySelective(RoleAnthortyInfo record);

    int updateByPrimaryKey(RoleAnthortyInfo record);
}