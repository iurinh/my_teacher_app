package com.iuri.my_teacher_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

public class TeamRegisterActivity extends Activity {

	CalendarView calendar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_team_register);
/*
		calendar = (CalendarView)findViewById(R.id.edit_calendar_view_first_day);
		calendar.setOnDateChangeListener(new OnDateChangeListener(){
			@Override
			public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
				Toast.makeText(getApplicationContext(),
						dayOfMonth +"/"+month+"/"+ year,Toast.LENGTH_LONG).show();
			}});*/
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.team_register, menu);
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
