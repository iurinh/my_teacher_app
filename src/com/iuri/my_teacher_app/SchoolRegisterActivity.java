package com.iuri.my_teacher_app;

import com.iuri.my_teacher_app.dao.DAO;
import com.iuri.my_teacher_app.dao.DAOSchool;
import com.iuri.my_teacher_app.entity.School;
import com.iuri.my_teacher_app.enums.EnumToast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SchoolRegisterActivity extends Activity {

	private EditText fieldName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school_register);
		
		getFields();
		
		createActionButtonSave(findViewById(R.id.button_save_new_school));
	}

	private Button createActionButtonSave(View view) {
		Button button = (Button) view;
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					School school = createSchool();

					DAO<School> dao = new DAOSchool(SchoolRegisterActivity.this);
					dao.add(school);
					
					Toast.makeText(SchoolRegisterActivity.this, EnumToast.SAVE_SUCCESSFULL.toString(), Toast.LENGTH_SHORT).show();
				}
		});
		return button;
	}

	private School createSchool() {
		
		School school = new School();
		school.setName(fieldName.getText().toString());
		
		return school;
	}

	private void getFields() {
		fieldName = (EditText) findViewById(R.id.edit_text_school_name);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.school_register, menu);
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
