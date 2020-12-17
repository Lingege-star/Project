package com.example.a1217lian.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DataBean {

    @Id
    private Long id;
    private String icon;
    private String background;
    private String activityIcon;
    private String title;
    private String intro;
    private int feedNum;
    private int tagId;
    private int enterNum;
    private int followNum;
    private boolean hasFollow;
    @Generated(hash = 2035490670)
    public DataBean(Long id, String icon, String background, String activityIcon,
            String title, String intro, int feedNum, int tagId, int enterNum,
            int followNum, boolean hasFollow) {
        this.id = id;
        this.icon = icon;
        this.background = background;
        this.activityIcon = activityIcon;
        this.title = title;
        this.intro = intro;
        this.feedNum = feedNum;
        this.tagId = tagId;
        this.enterNum = enterNum;
        this.followNum = followNum;
        this.hasFollow = hasFollow;
    }
    @Generated(hash = 908697775)
    public DataBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getBackground() {
        return this.background;
    }
    public void setBackground(String background) {
        this.background = background;
    }
    public String getActivityIcon() {
        return this.activityIcon;
    }
    public void setActivityIcon(String activityIcon) {
        this.activityIcon = activityIcon;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIntro() {
        return this.intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public int getFeedNum() {
        return this.feedNum;
    }
    public void setFeedNum(int feedNum) {
        this.feedNum = feedNum;
    }
    public int getTagId() {
        return this.tagId;
    }
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
    public int getEnterNum() {
        return this.enterNum;
    }
    public void setEnterNum(int enterNum) {
        this.enterNum = enterNum;
    }
    public int getFollowNum() {
        return this.followNum;
    }
    public void setFollowNum(int followNum) {
        this.followNum = followNum;
    }
    public boolean getHasFollow() {
        return this.hasFollow;
    }
    public void setHasFollow(boolean hasFollow) {
        this.hasFollow = hasFollow;
    }


}