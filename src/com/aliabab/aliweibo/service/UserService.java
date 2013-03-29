package com.aliabab.aliweibo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.aliabab.aliweibo.LoadActivity.UserSession;
import com.aliabab.aliweibo.pojo.ContentDO;
import com.aliabab.aliweibo.pojo.UserDO;
import com.aliabab.aliweibo.util.HttpHelper;
import com.aliabab.aliweibo.util.JsonObjectParser;

public class UserService {
	private static final String QUERY_USER_URL = "http://10.16.212.127/andriod/userdata.json";
	private static final String QUERY_FEED_LIST_URL = "http://10.16.212.127/andriod/feedlist.json";

	public UserDO queryUser(String userName, String password) {

		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("username", userName));
		params.add(new BasicNameValuePair("password", password));
		String param = URLEncodedUtils.format(params, "UTF-8");
		// 获取url
		String result = HttpHelper.executeHttpGet(QUERY_USER_URL + "?" + param);
		if (result == null) {
			return null;
		}
		UserDO userDO = JsonObjectParser.parseUserDO(result);
		return userDO;
	}

	public List<ContentDO> loadHomeData() {
		List<ContentDO> contentList = new ArrayList<ContentDO>();
		if (UserSession.nowUser == null) {
			return Collections.emptyList();
		}
		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("personId", UserSession.nowUser.getPersonId()));
		params.add(new BasicNameValuePair("count", "10"));
		String param = URLEncodedUtils.format(params, "UTF-8");
		String result = HttpHelper.executeHttpGet(QUERY_FEED_LIST_URL + "?" + param);
		if (result == null) {
			return null;
		}
		contentList = JsonObjectParser.parseContentList(result);
		return contentList;

	}
}
