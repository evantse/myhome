/**
 * @(#)ContentActivity.java
 * 
 * @Version: 1
 * @JDK: jdk 1.6.0.XXX
 * @Module: CrazyitWeibo
 */
/*- 				History
 **********************************************
 *  ID      DATE           PERSON       REASON
 *  1     2011-11-8     hanfei.li    Created
 **********************************************
 */

package com.aliabab.aliweibo;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * 官网 www.facejava.org www.fkjava.org 学习交流论坛 www.crazyit.org
 * 
 * @author hanfei.li
 * @since 2011-11-8
 */
public class ContentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content);

	}

}
