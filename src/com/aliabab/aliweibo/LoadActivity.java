package com.aliabab.aliweibo;

import java.util.List;

import com.aliabab.aliweibo.db.UserDAO;
import com.aliabab.aliweibo.pojo.UserDO;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.Toast;

public class LoadActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load);
		ImageView imageView = (ImageView) findViewById(R.id.logo);
		AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);
		animation.setDuration(2000);
		imageView.setAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {
			/**
			 * 动画弄1�7始时触发
			 */
			@Override
			public void onAnimationStart(Animation animation) {
				Toast.makeText(
						LoadActivity.this,
						LoadActivity.this.getResources().getText(
								R.string.load_top), Toast.LENGTH_SHORT).show();

			}

			/**
			 * 动画结束的时候执衄1�7
			 */
			@Override
			public void onAnimationEnd(Animation animation) {
				//动画执行完毕，就跳转登录
				 init();
			}

			/**
			 * 重复执行触发
			 */
			@Override
			public void onAnimationRepeat(Animation animation) {
			}

		});
	}
	
    /**
     * 初始匄1�7
     */
    public void init() {
        

        UserDAO services = new UserDAO(this);
        
        List<UserDO> users = services.findAllUsers();
     // 如果用户数据不存圄1�7,表示 从来没用过�1�7�跳到授 权�1�7�要么就到登录页靄1�7
        if (users == null || users.isEmpty()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else{
        	Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    /**
     * 保存当前用户数据
     * @author hanfei.li
     *
     */
    public static class UserSession {
        public static UserDO nowUser;
    }

}
