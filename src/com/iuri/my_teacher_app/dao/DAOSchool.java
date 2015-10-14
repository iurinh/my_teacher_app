package com.iuri.my_teacher_app.dao;

import java.util.List;

import com.iuri.my_teacher_app.entity.School;

import android.content.Context;
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
		/*StringBuffer sb = new StringBuffer();
		sb.append("CREATE TABLE " + TABLE);
		sb.append(" ( id INTEGER PRIMARY KEY , ");
		sb.append("   name TEXT UNIQUE NOT NULL , ");
		sb.append("   email TEXT UNIQUE NOT NULL , ");
		sb.append("   password NOT NULL);");
		
		db.execSQL(sb.toString());*/
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(School school) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(School school) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(School school) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public School search(School school) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<School> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
