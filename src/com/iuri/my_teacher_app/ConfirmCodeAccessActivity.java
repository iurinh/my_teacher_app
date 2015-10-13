package com.iuri.my_teacher_app;

import com.iuri.my_teacher_app.enums.EnumToast;
import com.iuri.my_teacher_app.utility.SenderEmail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ConfirmCodeAccessActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_code_access);
		
		createActionButtonNewCode(findViewById(R.id.button_new_code));
		createActionButtonConfirm(findViewById(R.id.button_confirm_code));
		createActionButtonCancel(findViewById(R.id.button_cancel_code));
	}

	private Button createActionButtonConfirm(View view) {
		Button button = (Button) view;
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ConfirmCodeAccessActivity.this, NewLoginActivity.class);
				Toast.makeText(ConfirmCodeAccessActivity.this, EnumToast.CHANGE_PASSWORD.toString(), Toast.LENGTH_LONG).show();
				//intent.putExtra("edit", false);
				startActivity(intent);
				finish();
			}
		});
		return button;
	}
	
	private Button createActionButtonNewCode(View view) {
		Button button = (Button) view;
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SenderEmail send = new SenderEmail("iurinh@hotmail.com", 1234);
				Intent intent = send.toSend();
				ConfirmCodeAccessActivity.this.startActivity(intent);
				Toast.makeText(ConfirmCodeAccessActivity.this, EnumToast.NEW_CODE_SENT.toString(), Toast.LENGTH_LONG).show();
			}
		});
		return button;
	}
	
	private Button createActionButtonCancel(View view) {
		Button button = (Button) view;
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ConfirmCodeAccessActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
		return button;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.confirm_code_access, menu);
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
