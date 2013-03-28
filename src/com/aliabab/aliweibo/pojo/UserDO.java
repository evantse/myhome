package com.aliabab.aliweibo.pojo;

import android.graphics.drawable.Drawable;

public class UserDO {

	private long id;
	private String personId;
	private String nickName;
	private int fans;
	private int friends;
	private Drawable icon;
	private String token;
	
    public static final String TB_NAME = "UserInfo";

    public static final String ID = "_id";
    public static final String PERSON_ID = "personId";
    public static final String NICK_NAME = "nickName";
    public static final String TOKEN = "token";
    public static final String ICON = "icon";
    public static final String FANS = "fans";
    public static final String FRIENDS = "friends";

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getFans() {
		return fans;
	}

	public void setFans(int fans) {
		this.fans = fans;
	}

	public int getFriends() {
		return friends;
	}

	public void setFriends(int friends) {
		this.friends = friends;
	}

	public Drawable getIcon() {
		return icon;
	}

	public void setIcon(Drawable icon) {
		this.icon = icon;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	



}
