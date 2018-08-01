package org.treeHole.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.treeHole.pojo.*;
import org.treeHole.service.essayService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Essay")
public class EssayController {

    @Autowired
    essayService essayService;

    // 获取所有文章信息
    @RequestMapping(value = "/getEssays", method = RequestMethod.GET)
    @ResponseBody
    public myPage getAllEssays(@RequestParam(required = false, defaultValue = "1") int pageCode,
                               @RequestParam(required = false, defaultValue = "5") int pageSize) {
        List<EssayInfo> list = essayService.getAllEssays();
        myPage myPage = new myPage();

        PageHelper.startPage(pageCode, pageSize);
        PageInfo<EssayInfo> userPageInfo = new PageInfo<>(list);

        myPage.setTotal(userPageInfo.getTotal());
        myPage.setRows(userPageInfo.getList());

        return myPage;
    }

    // 获取文章所有信息及评论
    @RequestMapping(value = "/EssayCompInfo", method = RequestMethod.POST)
    @ResponseBody
    public EssayANDComments getCompleteInfo(int essayId) {
        return essayService.getCompeletInfo(essayId);
    }

    // 发表文章
    @RequestMapping(value = "/addEssay", method = RequestMethod.POST)
    @ResponseBody
    public void addEssay(String info, HttpServletRequest request) {
        EssayInfo essayInfo = null;
        essayInfo.setInfo(info);

        int authorId = 0;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if("userId".equals(cookie.getName())) {
                authorId = Integer.parseInt(cookie.getValue());
            }
        }
        essayInfo.setAuthorid(authorId);
        essayInfo.setEssayid(essayService.getAllEssays().size());

        essayService.addEssay(essayInfo);
    }

    // 发表评论
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    @ResponseBody
    public void insertComment(String info, HttpServletRequest request) {
        EssayComments comment = null;
        comment.setCommentsinfo(info);
        Date date = new Date();
        String nowTime = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").format(date);
        Timestamp commentTime = Timestamp.valueOf(nowTime);
        comment.setCommentstime(commentTime);
        comment.setEssayid(essayService.getAllEssays().size()+1);

        // 从cookie中取得当前用户id
        int commentAuthorId = 0;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("userId".equals(cookie.getName())) {
                commentAuthorId = Integer.parseInt(cookie.getValue());
            }
        }
        comment.setCommentsuserid(commentAuthorId);

        // 添加评论
        essayService.insertComments(comment);
    }
}
