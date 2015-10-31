package com.iuri.my_teacher_app.dao;

import java.util.ArrayList;
import java.util.List;

import com.iuri.my_teacher_app.entity.Call;
import com.iuri.my_teacher_app.enums.EnumBoolean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOCall extends SQLiteOpenHelper implements DAO<Call>{

	private static final int VERSION = 1;
	private static final String DATABASE = "IuriDatabase";
	private static final String TABLE = "CALL";
	
	public DAOCall(Context context) {
		super(context, DATABASE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuffer sb = new StringBuffer();
		sb.append("CREATE TABLE " + TABLE);
		sb.append(" ( id INTEGER PRIMARY KEY , ");
		sb.append("   class_id INTEGER NOT NULL, ");
		sb.append("   student_id INTEGER NOT NULL , ");
		sb.append("   presence INTEGER NOT NULL , ");
		sb.append("   FOREIGN KEY(class_id) REFERENCES CLASS(id);");
		sb.append("   FOREIGN KEY(student_id) REFERENCES STUDENT(id);");
		
		db.execSQL(sb.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(Call call) {
		ContentValues values = new ContentValues();
		
		values.put("class_id", call.getClassId());
		values.put("student_id", call.getStudentId());
		values.put("presence", EnumBoolean.getOption(call.getPresence()));

		getWritableDatabase().insert(TABLE, null, values);
		
		close();
	}

	@Override
	public void delete(Call call) {
		String[] ids = {call.getId().toString()};
		getWritableDatabase().delete(TABLE,"id = ?", ids);
		close();
	}

	@Override
	public void update(Call call) {
		ContentValues values = new ContentValues();
		
		values.put("class_id", call.getClassId());
		values.put("student_id", call.getStudentId());
		values.put("presence", EnumBoolean.getOption(call.getPresence()));

		getWritableDatabase().update(TABLE, values, "id = " + call.getId(), null);
		close();
	}

	@Override
	public Call search(Call call) {
		String selectUser = "SELECT * FROM " + TABLE 
				+ " WHERE id = '" + call.getId() + ";";
		
		Cursor c = getReadableDatabase().rawQuery(selectUser, null);
		
		if(c.getCount() == 0) return null;
		
		while(c.moveToNext()){
			call.setClassId(c.getInt(c.getColumnIndex("class_id")));
			call.setStudentId(c.getInt(c.getColumnIndex("student_id")));
			call.setPresence(EnumBoolean.getValue(c.getInt(c.getColumnIndex("presence"))));
		}
		
		c.close();
		close();
		
		return call;
	}

	@Override
	public List<Call> searchAll() {
		String selectAll = "SELECT * FROM " + TABLE +" ;";
		
		Cursor c = getReadableDatabase().rawQuery(selectAll, null);
		
		List<Call> calls = new ArrayList<Call>();
		
		while(c.moveToNext()){
			Call call = new Call();
			
			call.setClassId(c.getInt(c.getColumnIndex("class_id")));
			call.setStudentId(c.getInt(c.getColumnIndex("student_id")));
			call.setPresence(EnumBoolean.getValue(c.getInt(c.getColumnIndex("presence"))));
			
			calls.add(call);
		}
		
		c.close();
		close();
		return calls;
	}

}
