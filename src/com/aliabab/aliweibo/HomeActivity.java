package com.aliabab.aliweibo;

import java.util.List;

import com.aliabab.aliweibo.adapter.HomeAdapters;
import com.aliabab.aliweibo.pojo.ContentDO;
import com.aliabab.aliweibo.service.UserService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class HomeActivity extends Activity {
	private static final String TAG = "HomeActivity";
	private ListView home_lv = null;
	private HomeAdapters adapater = null;
	private UserService userService;
	private LinearLayout load_progress = null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		home_lv = (ListView) findViewById(R.id.home_lv);
		load_progress = (LinearLayout) findViewById(R.id.load_progress);
		init();
	}

	/**
	 * 加载首页数据
	 */
	public void init() {
		userService = new UserService();
		// 获得主要显示的数据
		List<ContentDO> contentList = userService.loadHomeData();

		adapater = new HomeAdapters(this, contentList);
		// 设置listview上的item点击事件处理
		home_lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Object obj = view.getTag();
				if (obj != null) {
					// 获得一条weibo数据的id（唯一标识）
					String weiboId = obj.toString();
					// 跳转到一条具体的微博显示页面
					Intent intent = new Intent(HomeActivity.this,
							ContentActivity.class);
					Bundle bundle = new Bundle();
					// 参数的设置
					bundle.putString("weiboId", weiboId);
					// 参数绑定
					intent.putExtras(bundle);
					startActivity(intent);
				}
			}
		});
		// 将adapter和listview关联
		home_lv.setAdapter(adapater);
		// 隐藏进度条
		load_progress.setVisibility(View.GONE);

	}

}
