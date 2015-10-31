package com.iuri.my_teacher_app.dao;

import java.util.ArrayList;
import java.util.List;

import com.iuri.my_teacher_app.entity.Student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOStudent extends SQLiteOpenHelper implements DAO<Student>{

	private static final int VERSION = 1;
	private static final String DATABASE = "IuriDatabase";
	private static final String TABLE = "STUDENT";
	
	public DAOStudent(Context context) {
		super(context, DATABASE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuffer sb = new StringBuffer();
		sb.append("CREATE TABLE " + TABLE);
		sb.append(" ( id INTEGER PRIMARY KEY , ");
		sb.append("   team_id INTEGER NOT NULL, ");
		sb.append("   name TEXT NOT NULL , ");
		sb.append("   FOREIGN KEY(team_id) REFERENCES TEAM(id);");
		
		db.execSQL(sb.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(Student student) {
		ContentValues values = new ContentValues();
		
		values.put("team_id", student.getTeamId());
		values.put("name", student.getName());

		getWritableDatabase().insert(TABLE, null, values);
		
		close();
	}

	@Override
	public void delete(Student student) {
		String[] ids = {student.getId().toString()};
		getWritableDatabase().delete(TABLE,"id = ?", ids);
		close();
	}

	@Override
	public void update(Student student) {
		ContentValues values = new ContentValues();
		
		values.put("team_id", student.getTeamId());
		values.put("name", student.getName());
		
		getWritableDatabase().update(TABLE, values, "id = " + student.getId(), null);
		close();
	}

	@Override
	public Student search(Student student) {
		String selectUser = "SELECT * FROM " + TABLE 
				+ " WHERE id = '" + student.getId() + ";";
		
		Cursor c = getReadableDatabase().rawQuery(selectUser, null);
		
		if(c.getCount() == 0) return null;
		
		while(c.moveToNext()){
			student.setTeamId(c.getInt(c.getColumnIndex("team_id")));
			student.setName(c.getString(c.getColumnIndex("name")));
		}
		
		c.close();
		close();
		
		return student;
	}

	@Override
	public List<Student> searchAll() {
		String selectAll = "SELECT * FROM " + TABLE +" ;";
		
		Cursor c = getReadableDatabase().rawQuery(selectAll, null);
		
		List<Student> students = new ArrayList<Student>();
		
		while(c.moveToNext()){
			Student student = new Student();
			
			student.setTeamId(c.getInt(c.getColumnIndex("team_id")));
			student.setName(c.getString(c.getColumnIndex("name")));
			
			students.add(student);
		}
		
		c.close();
		close();
		return students;
	}

}
