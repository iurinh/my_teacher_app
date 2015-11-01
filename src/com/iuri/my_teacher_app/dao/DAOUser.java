package com.iuri.my_teacher_app.dao;

import java.util.ArrayList;
import java.util.List;

import com.iuri.my_teacher_app.digest.Digest;
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
		sb.append(" ( id INTEGER PRIMARY KEY AUTOINCREMENT, ");
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
		values.put("password", new Digest().getDigestMD5(user.getPassword()));

		getWritableDatabase().insert(TABLE, null, values);
		
		close();
	}

	@Override
	public void delete(User user) {
		String[] ids = {user.getId().toString()};
		getWritableDatabase().delete(TABLE,"id = ?", ids);
		close();
	}

	@Override
	public void update(User user) {
		ContentValues values = new ContentValues();
		values.put("name", user.getName());
		values.put("email", user.getEmail());
		values.put("password", new Digest().getDigestMD5(user.getPassword()));
		
		getWritableDatabase().update(TABLE, values, "id = " + user.getId(), null);
		close();
	}

	@Override
	public User search(User user) {
		if(user.getId() == null) user = searchForLoginPassword(user);
		else user = searchForId(user);
		
		close();
		
		return user;
	}

	private User searchForId(User user) {
		String selectUser = "SELECT * FROM " + TABLE 
				+ " WHERE id = '" + user.getId() + ";";
		
		Cursor c = getReadableDatabase().rawQuery(selectUser, null);
		
		if(c.getCount() == 0) return null;
		
		while(c.moveToNext()){
			user.setName(c.getString(c.getColumnIndex("name")));
			user.setEmail(c.getString(c.getColumnIndex("email")));
			user.setPassword(c.getString(c.getColumnIndex("password")));
		}
		
		c.close();
		return user;
	}

	private User searchForLoginPassword(User user) {
		String selectUser = "SELECT * FROM " + TABLE 
				+ " WHERE name LIKE '" + user.getName() + "'"
				+ " AND "
				+ " password LIKE '" + new Digest().getDigestMD5(user.getPassword()) + "'";
		
		Cursor c = getReadableDatabase().rawQuery(selectUser, null);
		
		if(c.getCount() == 0) return null;
		
		while(c.moveToNext()){
			user.setId(c.getInt(c.getColumnIndex("id")));
			user.setEmail(c.getString(c.getColumnIndex("email")));
		}
		
		c.close();
		return user;
	}

	@Override
	public List<User> searchAll() {
		String selectAll = "SELECT * FROM " + TABLE +" ;";
		
		Cursor c = getReadableDatabase().rawQuery(selectAll, null);
		
		List<User> users = new ArrayList<User>();
		
		while(c.moveToNext()){
			User user = new User();
			
			user.setId(c.getInt(c.getColumnIndex("id")));
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
