package org.treeHole.pojo;

import java.util.Date;

public class EssayComments {
    private Integer essayid;

    private Integer commentsuserid;

    private Date commentstime;

    private String commentsinfo;

    public Integer getEssayid() {
        return essayid;
    }

    public void setEssayid(Integer essayid) {
        this.essayid = essayid;
    }

    public Integer getCommentsuserid() {
        return commentsuserid;
    }

    public void setCommentsuserid(Integer commentsuserid) {
        this.commentsuserid = commentsuserid;
    }

    public Date getCommentstime() {
        return commentstime;
    }

    public void setCommentstime(Date commentstime) {
        this.commentstime = commentstime;
    }

    public String getCommentsinfo() {
        return commentsinfo;
    }

    public void setCommentsinfo(String commentsinfo) {
        this.commentsinfo = commentsinfo == null ? null : commentsinfo.trim();
    }
}