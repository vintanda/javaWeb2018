package org.treeHole.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.treeHole.pojo.User;
import org.treeHole.pojo.UserExample;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    // 自定义无主键添加
    int insertWithoutId(User record);
    User selectByNickname(String nickname);

}