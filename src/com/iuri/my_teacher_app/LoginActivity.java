package com.iuri.my_teacher_app;

import com.iuri.my_teacher_app.dao.DAO;
import com.iuri.my_teacher_app.dao.DAOUser;
import com.iuri.my_teacher_app.entity.User;
import com.iuri.my_teacher_app.enums.EnumToast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	
		createActionButtonNewLogin(findViewById(R.id.button_new_login));
		createActionButtonAccessLogin(findViewById(R.id.button_access_login));
		createActionTextForgotPassword(findViewById(R.id.text_forgot_password));
	}

	private void createActionTextForgotPassword(View view) {
		TextView textView = (TextView) view;
		textView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this, ConfirmCodeAccessActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	private Button createActionButtonNewLogin(View view) {
		Button button = (Button) view;
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this, NewLoginActivity.class);
				intent.putExtra("edit", true);
				startActivity(intent);
				finish();
			}
		});
		return button;
	}

	private Button createActionButtonAccessLogin(View view) {
		Button button = (Button) view;
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				User user = getUserOfLogin();
				
				DAO<User> dao = new DAOUser(LoginActivity.this);
				
				user = dao.search(user);
				
				if(user != null)
					Toast.makeText(LoginActivity.this, EnumToast.LOGIN_EXIST.toString(), Toast.LENGTH_LONG).show();
				else
					Toast.makeText(LoginActivity.this, EnumToast.LOGIN_NOT_EXIST.toString(), Toast.LENGTH_LONG).show();
			}
		});
		return button;
	}
	
	public User getUserOfLogin(){
		EditText txtLogin = (EditText) findViewById(R.id.edit_text_login);
		EditText txtPassword = (EditText) findViewById(R.id.edit_text_password);
		
		User user = new User();
		user.setName(txtLogin.getText().toString());
		user.setPassword(txtPassword.getText().toString());
		
		return user;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
