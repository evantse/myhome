package com.aliabab.aliweibo.util;

import org.json.JSONException;
import org.json.JSONObject;

import com.aliabab.aliweibo.pojo.UserDO;

public class JsonObjectParser {

	public static UserDO parseUserDO(String result) {
		UserDO user = new UserDO();
		try {
			JSONObject jsonObject = new JSONObject(result).getJSONObject("userbean");
			
			user.setId(jsonObject.getLong("id"));
			user.setPersonId(jsonObject.getString("personId"));
			user.setNickName(jsonObject.getString("nickName"));
			user.setFans(jsonObject.getInt("fans"));
			user.setFriends(jsonObject.getInt("friends"));
			user.setIcon(Download.getDrawableFromUrl(jsonObject.getString("icon")));
		} catch (JSONException e) {
			return null;
		} 
		return user;
	}

}
