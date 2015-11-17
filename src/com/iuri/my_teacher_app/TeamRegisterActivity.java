package com.iuri.my_teacher_app;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.iuri.my_teacher_app.enums.EnumDateFormatter;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class TeamRegisterActivity extends Activity{
	/**
	 * Primeiro dia de aula
	 */
	private Date firtDay = null;
	
	/**
	 * Ultimo dia de aula
	 */
	private Date lastDay = null;

	private EditText fieldSerie;
	private EditText fieldName;
	private EditText fieldFirstDay;
	private EditText fieldLastDay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_team_register);
		
		getFields();
		
		setEventTextViewFirtDay(findViewById(R.id.edit_text_team_first_day));
		setEventTextViewLastDay(findViewById(R.id.edit_text_team_last_day));
	}
	
	private void getFields() {
		fieldSerie = (EditText) findViewById(R.id.edit_text_team_serie);
		fieldName = (EditText) findViewById(R.id.edit_text_team_name);
		fieldFirstDay = (EditText) findViewById(R.id.edit_text_team_first_day);
		fieldLastDay = (EditText) findViewById(R.id.edit_text_team_last_day);
	}

	/**
	 * Evento para invocar caixa de dialogo oara selecionar data
	 * @param view
	 */
	private void setEventTextViewFirtDay(final View view) {
		view.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(TeamRegisterActivity.this);
				dialog.setContentView(R.layout.dialog_date);
				dialog.setTitle(R.string.text_view_first_day);
				
				Button btnOk = (Button) dialog.findViewById(R.id.btnDatePickerOk);
				Button btnCancel = (Button) dialog.findViewById(R.id.btnDatePickerCancel);
				
				btnOk.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						DatePicker dp = (DatePicker) dialog.findViewById(R.id.date_piker_date);
						Long timeSeconds = dp.getCalendarView().getDate();
						
						firtDay = new Date(timeSeconds);
						SimpleDateFormat sdf = new SimpleDateFormat(EnumDateFormatter.SIMPLE.toString());
						fieldFirstDay.setText(String.valueOf(sdf.format(firtDay)));
						
						dialog.dismiss();
					}
				});
				
				btnCancel.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
				
				dialog.show();
			}
		});
	}
	
	/**
	 * Evento para invocar caixa de dialogo oara selecionar data
	 * @param view
	 */
	private void setEventTextViewLastDay(final View view) {
		view.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(TeamRegisterActivity.this);
				dialog.setContentView(R.layout.dialog_date);
				dialog.setTitle(R.string.text_view_last_day);
				
				Button btnOk = (Button) dialog.findViewById(R.id.btnDatePickerOk);
				Button btnCancel = (Button) dialog.findViewById(R.id.btnDatePickerCancel);
				
				btnOk.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						DatePicker dp = (DatePicker) dialog.findViewById(R.id.date_piker_date);
						Long timeSeconds = dp.getCalendarView().getDate();
						
						lastDay = new Date(timeSeconds);
						
						SimpleDateFormat sdf = new SimpleDateFormat(EnumDateFormatter.SIMPLE.toString());
						fieldLastDay.setText(String.valueOf(sdf.format(lastDay)));
						
						dialog.dismiss();
					}
				});
				
				btnCancel.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
				
				dialog.show();
			}
		});
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
