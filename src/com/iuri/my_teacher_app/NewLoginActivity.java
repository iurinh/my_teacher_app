package com.iuri.my_teacher_app;

import java.util.List;

import com.iuri.my_teacher_app.dao.DAO;
import com.iuri.my_teacher_app.dao.DAOUser;
import com.iuri.my_teacher_app.digest.Digest;
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
import android.widget.Toast;

public class NewLoginActivity extends Activity {

	private EditText fieldName;
	private EditText fieldEmail;
	private EditText fieldPassword;
	private EditText fieldConfirmPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_login);
		
		getFields();
		
		createActionButtonSave(findViewById(R.id.button_save_new_login));
		createActionButtonCancel(findViewById(R.id.button_cancel_register));
	}
	
	private boolean validatePassword() {
		String password = fieldPassword.getText().toString();
		String confirmPassword = fieldConfirmPassword.getText().toString();
		return password.equals(confirmPassword);
	}

	private void getFields() {
		fieldName = 			(EditText) findViewById(R.id.edit_text_name);
		fieldEmail = 			(EditText) findViewById(R.id.edit_text_email);
		fieldPassword = 		(EditText) findViewById(R.id.edit_text_password);
		fieldConfirmPassword = (EditText) findViewById(R.id.edit_text_confirm_password);
	}

	private Button createActionButtonSave(View view) {
		Button button = (Button) view;
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(validatePassword()) {
					
					User user = createUser();

					DAO<User> dao = new DAOUser(NewLoginActivity.this);
					dao.add(user);
					
					DAO<User> daoTeste = new DAOUser(NewLoginActivity.this);
					List<User> users = daoTeste.searchAll();
					
					for (User userTeste : users) {
						Toast.makeText(NewLoginActivity.this, userTeste.getName() + " " + userTeste.getEmail() + " " + userTeste.getPassword(), Toast.LENGTH_LONG).show();
					}
					Toast.makeText(NewLoginActivity.this, EnumToast.SAVE_SUCCESSFULL.toString(), Toast.LENGTH_LONG).show();
					
					Intent intent = new Intent(NewLoginActivity.this, LoginActivity.class);
					startActivity(intent);
					finish();
				}
			}
		});
		return button;
	}

	private User createUser() {
		User user = new User();
		user.setName(fieldName.getText().toString());
		user.setEmail(fieldEmail.getText().toString());
		user.setPassword(encryptPassWord());
		return user;
	}
	
	private String encryptPassWord() {
		Digest digest = new Digest();
		return digest.getDigestMD5(fieldPassword.getText().toString(), NewLoginActivity.this);
	}

	private Button createActionButtonCancel(View view) {
		Button button = (Button) view;
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(NewLoginActivity.this, LoginActivity.class);
				Toast.makeText(NewLoginActivity.this, EnumToast.REGISTER_CANCELED.toString(), Toast.LENGTH_LONG).show();
				startActivity(intent);
				finish();
			}
		});
		return button;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_login, menu);
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
