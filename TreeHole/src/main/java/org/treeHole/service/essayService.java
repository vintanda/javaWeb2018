package org.treeHole.service;

import org.treeHole.pojo.EssayANDComments;
import org.treeHole.pojo.EssayComments;
import org.treeHole.pojo.EssayInfo;

import java.util.List;

public interface essayService {

    // 获取所有文章信息
    List<EssayInfo> getAllEssays();

    // 获取某篇文章的全部信息,包括评论
    EssayANDComments getCompeletInfo(int essayId);

    // 发表文章
    int addEssay(EssayInfo essayInfo);

    // 评论功能
    int insertComments(EssayComments comment);

}
