package org.treeHole.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.treeHole.pojo.EssayComments;
import org.treeHole.pojo.EssayCommentsExample;

public interface EssayCommentsMapper {
    int countByExample(EssayCommentsExample example);

    int deleteByExample(EssayCommentsExample example);

    int deleteByPrimaryKey(Integer essayid);

    int insert(EssayComments record);

    int insertSelective(EssayComments record);

    List<EssayComments> selectByExample(EssayCommentsExample example);

    EssayComments selectByPrimaryKey(Integer essayid);

    int updateByExampleSelective(@Param("record") EssayComments record, @Param("example") EssayCommentsExample example);

    int updateByExample(@Param("record") EssayComments record, @Param("example") EssayCommentsExample example);

    int updateByPrimaryKeySelective(EssayComments record);

    int updateByPrimaryKey(EssayComments record);
}