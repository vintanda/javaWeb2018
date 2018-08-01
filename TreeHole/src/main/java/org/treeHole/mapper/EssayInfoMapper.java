package org.treeHole.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.treeHole.pojo.EssayInfo;
import org.treeHole.pojo.EssayInfoExample;

public interface EssayInfoMapper {
    int countByExample(EssayInfoExample example);

    int deleteByExample(EssayInfoExample example);

    int deleteByPrimaryKey(Integer essayid);

    int insert(EssayInfo record);

    int insertSelective(EssayInfo record);

    List<EssayInfo> selectByExample(EssayInfoExample example);

    EssayInfo selectByPrimaryKey(Integer essayid);

    int updateByExampleSelective(@Param("record") EssayInfo record, @Param("example") EssayInfoExample example);

    int updateByExample(@Param("record") EssayInfo record, @Param("example") EssayInfoExample example);

    int updateByPrimaryKeySelective(EssayInfo record);

    int updateByPrimaryKey(EssayInfo record);
}