package com.aliabab.aliweibo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.aliabab.aliweibo.pojo.ContentDO;
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

	public static List<ContentDO> parseContentList(String result) {
		List<ContentDO> contentList = new ArrayList<ContentDO>();
		try {
			JSONObject jsonObject = new JSONObject(result);
			JSONArray nameList = jsonObject.getJSONArray("feedList");
			int length = nameList.length(); 
			for(int i = 0; i < length; i++){
				JSONObject feed = nameList.getJSONObject(i); 
				ContentDO contentDO = new ContentDO();
				contentDO.setId(feed.getLong("id"));
				contentDO.setContent(feed.getString("content"));
				String imageUrl = feed.getString("imgUrl");
				if(!"".equals(imageUrl)&&imageUrl!=null){
					contentDO.setImageUrl(imageUrl);
					contentDO.setHaveImage(true);
				}
				contentDO.setNickName(feed.getString("nickName"));
				contentDO.setTime(feed.getString("createTime"));
				contentDO.setUserIcon(feed.getString("userIcon"));
				contentList.add(contentDO);
				
			}
		} catch (JSONException e) {
			return Collections.emptyList();
		}
		
		return contentList;
	}

}
