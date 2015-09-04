package com.iuri.my_teacher_app.dao;

import java.util.ArrayList;
import java.util.List;

import com.iuri.my_teacher_app.entity.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOUser extends SQLiteOpenHelper implements DAO<User>{

	private static final int VERSION = 1;
	private static final String DATABASE = "IuriDatabase";
	private static final String TABLE = "USER";
	

	public DAOUser(Context context) {
		super(context, DATABASE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuffer sb = new StringBuffer();
		sb.append("CREATE TABLE " + TABLE);
		sb.append(" ( id INTEGER PRIMARY KEY , ");
		sb.append("   name TEXT UNIQUE NOT NULL , ");
		sb.append("   email TEXT UNIQUE NOT NULL , ");
		sb.append("   password NOT NULL);");
		
		db.execSQL(sb.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(User user) {
		ContentValues values = new ContentValues();
		
		values.put("name", user.getName());
		values.put("email", user.getEmail());
		values.put("password", user.getPassword());

		getWritableDatabase().insert(TABLE, null, values);
		
		close();
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User search(User user) {
		return user;
	}

	@Override
	public List<User> searchAll() {
		String selectAll = "SELECT * FROM " + TABLE +" ;";
		
		Cursor c = getReadableDatabase().rawQuery(selectAll, null);
		
		List<User> users = new ArrayList<User>();
		
		while(c.moveToNext()){
			User user = new User();
			
			user.setName(c.getString(c.getColumnIndex("name")));
			user.setEmail(c.getString(c.getColumnIndex("email")));
			user.setPassword(c.getString(c.getColumnIndex("password")));
			
			users.add(user);
		}
		
		c.close();
		close();
		return users;
	}

}
