package org.treeHole.pojo;

/*
    文章基本内容：文章id 摘要 作者id
 */
public class EssayInfo {

    private Integer essayid;

    private String info;

    private Integer authorid;

    public Integer getEssayid() {
        return essayid;
    }

    public void setEssayid(Integer essayid) {
        this.essayid = essayid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }
}