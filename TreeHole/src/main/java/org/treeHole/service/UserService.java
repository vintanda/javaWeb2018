package org.treeHole.service;

import org.treeHole.pojo.User;

import java.util.List;

public interface UserService {

    // 增
    int insertUser(User user);

    // 删
    int deleteUserById(int id);

    // 改
    int updateUserInfo(User user);

    // 查 ---- 所有用户
    List<User> selectAllUsers();

    // 查 ---- 某个用户
    User selectUserInfoById(int id);

    // 查 ---- 某个用户
    User selectUserInfoByNickname(String nickname);

    // 查 ---- 模糊查询符合条件的用户
    List<User> selectUsersByNickname(String nickname);

}
