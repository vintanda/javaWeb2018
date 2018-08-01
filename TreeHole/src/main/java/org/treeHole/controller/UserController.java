package org.treeHole.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.treeHole.pojo.User;
import org.treeHole.pojo.myPage;
import org.treeHole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/view/{path}")
    public String view(@PathVariable String path) {
        return path;
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    @ResponseBody
    public myPage getAllUsers(@RequestParam(required = false, defaultValue = "1") int pageCode,
                              @RequestParam(required = false, defaultValue = "8") int pageSize) {
        List<User> list = userService.selectAllUsers();
        myPage myPage = new myPage();

        PageHelper.startPage(pageCode, pageSize);
        PageInfo<User> userPageInfo = new PageInfo<>(list);

        myPage.setTotal(userPageInfo.getTotal());
        myPage.setRows(userPageInfo.getList());

        return myPage;
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(int id) {
        return userService.selectUserInfoById(id);
    }

    @RequestMapping("/getUsersLike")
    @ResponseBody
    public List<User> getUsersLikeByNickname(String nickname) {
        return userService.selectUsersByNickname(nickname);
    }

    // 注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public int register(User user) {
        return userService.insertUser(user);
    }

    // 登陆
    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
    @ResponseBody
    public User login(String nickname, String password, HttpServletResponse response, HttpServletRequest request) {
        User user = userService.selectUserInfoByNickname(nickname);
        if(user != null) {
            // 登陆成功,添加该用户的Cookie
            if (user.getPassword().equals(password)) {
                addCookie(nickname, password, response, request);
                return user;
            }
        }
        return null;
    }

    // 登陆时添加Cookie用于保存用户的 id nickname password
    private String addCookie(String nickname, String password, HttpServletResponse response, HttpServletRequest request) {
        // 创建Cookie
        Cookie nicknameCookie = new Cookie("nickname", nickname);
        Cookie passwordCookie = new Cookie("password", password);

        // 设置Cookie的父路径
        nicknameCookie.setPath(request.getContextPath() + "/");
        passwordCookie.setPath(request.getContextPath() + "/");

        // 加到响应头
        response.addCookie(nicknameCookie);
        response.addCookie(passwordCookie);

        return "myPage";
    }

    // 删除用户
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.GET)
    @ResponseBody
    public int deleteUser(int id) {
        userService.deleteUserById(id);
        return 0;
    }

    // 更新用户信息
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public int updateUser(User user) {
        userService.updateUserInfo(user);
        return 1;
    }

}