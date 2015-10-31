package com.iuri.my_teacher_app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iuri.my_teacher_app.entity.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOClass extends SQLiteOpenHelper implements DAO<Class>{

	private static final int VERSION = 1;
	private static final String DATABASE = "IuriDatabase";
	private static final String TABLE = "CLASS";
	
	public DAOClass(Context context) {
		super(context, DATABASE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuffer sb = new StringBuffer();
		sb.append("CREATE TABLE " + TABLE);
		sb.append(" ( id INTEGER PRIMARY KEY , ");
		sb.append("   team_id INTEGER NOT NULL, ");
		sb.append("   day_week INTEGER NOT NULL , ");
		sb.append("   hour_init INTEGER NOT NULL , ");
		sb.append("   hour_end INTEGER NOT NULL , ");
		sb.append("   FOREIGN KEY(team_id) REFERENCES TEAM(id);");
		
		db.execSQL(sb.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(Class clas) {
		ContentValues values = new ContentValues();
		
		values.put("team_id", clas.getTeamId());
		values.put("day_week", clas.getDayWeek());
		values.put("hour_init", clas.getHourInit().getTime());
		values.put("hour_end", clas.getHourEnd().getTime());

		getWritableDatabase().insert(TABLE, null, values);
		
		close();
	}

	@Override
	public void delete(Class clas) {
		String[] ids = {clas.getId().toString()};
		getWritableDatabase().delete(TABLE,"id = ?", ids);
		close();
	}

	@Override
	public void update(Class clas) {
		ContentValues values = new ContentValues();
		
		values.put("team_id", clas.getTeamId());
		values.put("day_week", clas.getDayWeek());
		values.put("hour_init", clas.getHourInit().getTime());
		values.put("hour_end", clas.getHourEnd().getTime());
		
		getWritableDatabase().update(TABLE, values, "id = " + clas.getId(), null);
		close();
	}

	@Override
	public Class search(Class clas) {
		String selectUser = "SELECT * FROM " + TABLE 
				+ " WHERE id = '" + clas.getId() + ";";
		
		Cursor c = getReadableDatabase().rawQuery(selectUser, null);
		
		if(c.getCount() == 0) return null;
		
		while(c.moveToNext()){
			clas.setTeamId(c.getInt(c.getColumnIndex("team_id")));
			clas.setDayWeek(c.getInt(c.getColumnIndex("day_week")));
			clas.setHourInit(new Date(c.getLong(c.getColumnIndex("hour_init"))));
			clas.setHourEnd(new Date(c.getLong(c.getColumnIndex("hour_end"))));
		}
		
		c.close();
		close();
		
		return clas;
	}

	@Override
	public List<Class> searchAll() {
		String selectAll = "SELECT * FROM " + TABLE +" ;";
		
		Cursor c = getReadableDatabase().rawQuery(selectAll, null);
		
		List<Class> classes = new ArrayList<Class>();
		
		while(c.moveToNext()){
			Class clas = new Class();
			
			clas.setTeamId(c.getInt(c.getColumnIndex("team_id")));
			clas.setDayWeek(c.getInt(c.getColumnIndex("day_week")));
			clas.setHourInit(new Date(c.getLong(c.getColumnIndex("hour_init"))));
			clas.setHourEnd(new Date(c.getLong(c.getColumnIndex("hour_end"))));
			
			classes.add(clas);
		}
		
		c.close();
		close();
		return classes;
	}

}
