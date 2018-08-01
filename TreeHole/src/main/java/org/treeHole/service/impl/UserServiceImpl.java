package org.treeHole.service.impl;

import org.treeHole.mapper.UserMapper;
import org.treeHole.pojo.User;
import org.treeHole.pojo.UserExample;
import org.treeHole.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /*
    insert into user(ID,username,password,email)
                    values ('dsfgsdfgdsfgds','admin','admin','wyw@126.com');
    User user = new User();
    user.setId("dsfgsdfgdsfgds");
    user.setUsername("admin");
    user.setPassword("admin")
    user.setEmail("wyw@163.com");
    XxxMapper.insert(user);
     */
    // 添加用户,对注册的用户添加
    @Override
    public int insertUser(User user) {
        userMapper.insert(user);

        // 自定义无主键添加User
//        userMapper.insertWithoutId(user);
        return user.getUserid();
    }

    // 根据主键删除用户
    @Override
    public int deleteUserById(int id) {
        userMapper.deleteByPrimaryKey(id);
        return 1;
    }

    // 更新用户信息 等同于 update user set ... = ... where id = user.getId();
    @Override
    public int updateUserInfo(User user) {
        userMapper.updateByPrimaryKey(user);
        return 0;
    }

    // 列出所有的用户
    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectByExample(null);
    }

    // 通过传入id获取某一个用户的全部信息
    @Override
    public User selectUserInfoById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User selectUserInfoByNickname(String nickname) {
        return userMapper.selectByNickname(nickname);
    }

    // 通过昵称查询用户,此时并不罗列所有的信息,只显示nickname和info字段
    @Override
    public List<User> selectUsersByNickname(String nickname) {
        // 使用Example类进行自定义操作
        UserExample userExample = new UserExample();

        // Criteria是一个语句约束条件的对象
        UserExample.Criteria criteria = userExample.createCriteria();
        /*
         添加模糊查询的条件是昵称模糊查询
         criteria.andXxxNotLike(“%”+value+”%”)
          */
        criteria.andNicknameLike("%" + nickname + "%");

        return userMapper.selectByExample(userExample);
    }




}
