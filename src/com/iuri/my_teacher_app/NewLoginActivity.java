package com.iuri.my_teacher_app;

import com.iuri.my_teacher_app.enums.EnumToast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NewLoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_login);
		
		createActionButtonSave(findViewById(R.id.button_save_new_login));
		createActionButtonCancel(findViewById(R.id.button_cancel_register));
	}
	
	private Button createActionButtonSave(View view) {
		Button button = (Button) view;
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(NewLoginActivity.this, LoginActivity.class);
				Toast.makeText(NewLoginActivity.this, EnumToast.SAVE_SUCCESSFULL.toString(), Toast.LENGTH_LONG).show();
				startActivity(intent);
				finish();
			}
		});
		return button;
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
