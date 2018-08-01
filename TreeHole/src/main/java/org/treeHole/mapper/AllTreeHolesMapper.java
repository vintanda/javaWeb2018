package org.treeHole.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.treeHole.pojo.AllTreeHoles;
import org.treeHole.pojo.AllTreeHolesExample;

public interface AllTreeHolesMapper {
    int countByExample(AllTreeHolesExample example);

    int deleteByExample(AllTreeHolesExample example);

    int deleteByPrimaryKey(Integer essayid);

    int insert(AllTreeHoles record);

    int insertSelective(AllTreeHoles record);

    List<AllTreeHoles> selectByExample(AllTreeHolesExample example);

    AllTreeHoles selectByPrimaryKey(Integer essayid);

    int updateByExampleSelective(@Param("record") AllTreeHoles record, @Param("example") AllTreeHolesExample example);

    int updateByExample(@Param("record") AllTreeHoles record, @Param("example") AllTreeHolesExample example);

    int updateByPrimaryKeySelective(AllTreeHoles record);

    int updateByPrimaryKey(AllTreeHoles record);
}