package org.treeHole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.treeHole.mapper.EssayCommentsMapper;
import org.treeHole.mapper.EssayInfoMapper;
import org.treeHole.pojo.*;
import org.treeHole.service.essayService;

import javax.servlet.http.Cookie;
import java.util.List;

@Service("essayService")
public class essayServiceImpl implements essayService {

    @Autowired
    private EssayInfoMapper essayInfoMapper;

    @Autowired
    private EssayCommentsMapper essayCommentsMapper;

    // 获取所有文章信息(不含评论)
    @Override
    public List<EssayInfo> getAllEssays() {
        return essayInfoMapper.selectByExample(null);
    }

    // 获取某篇文章的详细信息以及所有评论信息,评论信息按时间顺序获取
    @Override
    public EssayANDComments getCompeletInfo(int essayId) {
        EssayANDComments essayANDComments = null;
        // 获取文章详细信息
        essayANDComments.setEssay(essayInfoMapper.selectByPrimaryKey(essayId));

        // 按时间顺序获取文章的所有评论
        EssayCommentsExample example = new EssayCommentsExample();
        EssayCommentsExample.Criteria criteria = example.createCriteria();
        criteria.andEssayidEqualTo(essayId);
        example.setOrderByClause("commentstime desc");
        essayANDComments.setComments(essayCommentsMapper.selectByPrimaryKey(essayId));

        // 返回得到的所有信息
        return essayANDComments;
    }

    @Override
    public int addEssay(EssayInfo essayInfo) {
        essayInfoMapper.insert(essayInfo);
        return 0;
    }

    // 评论功能
    @Override
    public int insertComments(EssayComments comment) {
        return essayCommentsMapper.insert(comment);
    }
}
