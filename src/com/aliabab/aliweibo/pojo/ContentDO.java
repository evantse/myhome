package com.aliabab.aliweibo.pojo;


public class ContentDO {
    // 文章id
    private long id;
    // 文章内容
    private String content;
    // 发布人id
    private String personId;
    // 发布人名字
    private String nickName;
    // 发布人头像
    private String userIcon;
    // 发布时间
    private String time;
    // 是否有图片
    private Boolean haveImage = false;
    //显示图片内容
    private String imageUrl;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Boolean getHaveImage() {
		return haveImage;
	}
	public void setHaveImage(Boolean haveImage) {
		this.haveImage = haveImage;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

    
    



}