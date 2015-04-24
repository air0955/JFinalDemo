package com.zjhcsoft.uop.demo.controllers;

import com.jfinal.plugin.activerecord.Record;

public class MyRecord extends Record {
	
	@Override
	public Record set(String column, Object value) {
		if(value instanceof java.util.Date){
			return super.set(column, new java.sql.Timestamp(((java.util.Date)value).getTime()));
		}
		return super.set(column, value);
	}

}
