package com.aliabab.aliweibo;



import com.aliabab.aliweibo.db.UserDAO;
import com.aliabab.aliweibo.pojo.UserDO;
import com.aliabab.aliweibo.service.UserService;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity implements OnClickListener {

	private TextView userNameView = null;
	private TextView passwordView = null;
	private Button login, close = null;
	private UserService  userService ;
	private UserDAO userDAO;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		userNameView = (TextView) findViewById(R.id.user_name);
		passwordView = (TextView) findViewById(R.id.password);
		login = (Button) findViewById(R.id.login);
		close = (Button) findViewById(R.id.close);
		login.setOnClickListener(LoginActivity.this);
		close.setOnClickListener(LoginActivity.this);
		userService = new UserService();
		userDAO = new UserDAO(LoginActivity.this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login:
			String userName = userNameView.getText().toString();
			if (userName == null || "".equals(userName)) {
				userNameView.setError(getResources().getText(R.string.no_user),
						getResources().getDrawable(R.drawable.not));
				return ;
			}
			String password = passwordView.getText().toString();
			if (password == null || "".equals(password)) {
				passwordView.setError(getResources().getText(R.string.no_password),
						getResources().getDrawable(R.drawable.not));
				return ;
			}
			UserDO userDO = userService.queryUser(userName, password);
			if(userDO==null){
				//登录 出错
				userNameView.setError(getResources().getText(R.string.no_user),
						getResources().getDrawable(R.drawable.not));
				
			}else{
				userDAO.insertUserDO(userDO);
				Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
	            startActivity(intent);
	            finish();
			}
			
			
			break;
		case R.id.close:
			this.finish();
			break;
		}

	}

}
