package com.iuri.my_teacher_app.dao;

import java.util.ArrayList;
import java.util.List;

import com.iuri.my_teacher_app.entity.School;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOSchool extends SQLiteOpenHelper implements DAO<School>{

	private static final int VERSION = 1;
	private static final String DATABASE = "IuriDatabase";
	private static final String TABLE = "SCHOOL";
	
	public DAOSchool(Context context) {
		super(context, DATABASE, null, VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuffer sb = new StringBuffer();
		sb.append("CREATE TABLE " + TABLE);
		sb.append(" ( id INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sb.append("   name TEXT NOT NULL ); ");
		
		db.execSQL(sb.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(School school) {
		ContentValues values = new ContentValues();
		
		values.put("name", school.getName());

		getWritableDatabase().insert(TABLE, null, values);
		
		close();
	}

	@Override
	public void delete(School school) {
		String[] ids = {school.getId().toString()};
		getWritableDatabase().delete(TABLE,"id = ?", ids);
		close();
	}

	@Override
	public void update(School school) {
		ContentValues value = new ContentValues();
		value.put("name", school.getName());
		
		getWritableDatabase().update(TABLE, value, "id = " + school.getId(), null);
		close();
	}

	@Override
	public School search(School school) {
		String selectUser = "SELECT * FROM " + TABLE 
				+ " WHERE id = '" + school.getId() + ";";
		
		Cursor c = getReadableDatabase().rawQuery(selectUser, null);
		
		if(c.getCount() == 0) return null;
		
		while(c.moveToNext()){
			school.setName(c.getString(c.getColumnIndex("name")));
		}
		
		c.close();
		close();
		
		return school;
	}

	@Override
	public List<School> searchAll() {
		String selectAll = "SELECT * FROM " + TABLE +" ;";
		
		Cursor c = getReadableDatabase().rawQuery(selectAll, null);
		
		List<School> schools = new ArrayList<School>();
		
		while(c.moveToNext()){
			School school = new School();
			
			school.setId(c.getInt(c.getColumnIndex("id")));
			school.setName(c.getString(c.getColumnIndex("name")));
			
			schools.add(school);
		}
		
		c.close();
		close();
		
		return schools;
	}

}
