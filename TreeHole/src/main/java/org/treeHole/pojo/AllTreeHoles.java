package org.treeHole.pojo;

import java.util.Date;

public class AllTreeHoles {
    private Integer essayid;

    private Integer userid;

    private Date releasetime;

    private String tag;

    public Integer getEssayid() {
        return essayid;
    }

    public void setEssayid(Integer essayid) {
        this.essayid = essayid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}