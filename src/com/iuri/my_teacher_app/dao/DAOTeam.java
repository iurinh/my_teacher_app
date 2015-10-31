package com.iuri.my_teacher_app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iuri.my_teacher_app.entity.Team;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOTeam extends SQLiteOpenHelper implements DAO<Team>{

	private static final int VERSION = 1;
	private static final String DATABASE = "IuriDatabase";
	private static final String TABLE = "TEAM";
	
	public DAOTeam(Context context) {
		super(context, DATABASE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuffer sb = new StringBuffer();
		sb.append("CREATE TABLE " + TABLE);
		sb.append(" ( id INTEGER PRIMARY KEY , ");
		sb.append("   school_id INTEGER NOT NULL, ");
		sb.append("   serie TEXT NOT NULL , ");
		sb.append("   name TEXT NOT NULL , ");
		sb.append("   dt_init INTEGER NOT NULL , ");
		sb.append("   dt_end INTEGER NOT NULL , ");
		sb.append("   FOREIGN KEY(school_id) REFERENCES SCHOOL(id);");
		
		db.execSQL(sb.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(Team team) {
		ContentValues values = new ContentValues();
		
		values.put("school_id", team.getSchoolId());
		values.put("serie", team.getSerie());
		values.put("name", team.getName());
		values.put("dt_init", team.getDtInit().getTime());
		values.put("dt_end", team.getDtEnd().getTime());

		getWritableDatabase().insert(TABLE, null, values);
		
		close();
	}

	@Override
	public void delete(Team team) {
		String[] ids = {team.getId().toString()};
		getWritableDatabase().delete(TABLE,"id = ?", ids);
		close();
	}

	@Override
	public void update(Team team) {
		ContentValues values = new ContentValues();
		
		values.put("school_id", team.getSchoolId());
		values.put("serie", team.getSerie());
		values.put("name", team.getName());
		values.put("dt_init", team.getDtInit().getTime());
		values.put("dt_end", team.getDtEnd().getTime());
		
		getWritableDatabase().update(TABLE, values, "id = " + team.getId(), null);
		close();
	}

	@Override
	public Team search(Team team) {
		String selectUser = "SELECT * FROM " + TABLE 
				+ " WHERE id = '" + team.getId() + ";";
		
		Cursor c = getReadableDatabase().rawQuery(selectUser, null);
		
		if(c.getCount() == 0) return null;
		
		while(c.moveToNext()){
			team.setSchoolId(c.getInt(c.getColumnIndex("school_id")));
			team.setSerie(c.getString(c.getColumnIndex("serie")));
			team.setName(c.getString(c.getColumnIndex("name")));
			team.setDtInit(new Date(c.getLong(c.getColumnIndex("dt_init"))));
			team.setDtEnd(new Date(c.getLong(c.getColumnIndex("dt_end"))));
		}
		
		c.close();
		close();
		
		return team;
	}

	@Override
	public List<Team> searchAll() {
		String selectAll = "SELECT * FROM " + TABLE +" ;";
		
		Cursor c = getReadableDatabase().rawQuery(selectAll, null);
		
		List<Team> teams = new ArrayList<Team>();
		
		while(c.moveToNext()){
			Team team = new Team();
			
			team.setSchoolId(c.getInt(c.getColumnIndex("school_id")));
			team.setSerie(c.getString(c.getColumnIndex("serie")));
			team.setName(c.getString(c.getColumnIndex("name")));
			team.setDtInit(new Date(c.getLong(c.getColumnIndex("dt_init"))));
			team.setDtEnd(new Date(c.getLong(c.getColumnIndex("dt_end"))));
			
			teams.add(team);
		}
		
		c.close();
		close();
		return teams;
	}

}
