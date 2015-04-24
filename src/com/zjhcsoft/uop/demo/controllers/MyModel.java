package com.zjhcsoft.uop.demo.controllers;

import java.sql.Timestamp;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("hiding")
public class MyModel<M extends Model> extends Model{

	@Override
	public Model set(String attr, Object value) {
		// TODO Auto-generated method stub
		if(value instanceof java.util.Date){
			return super.set(attr, new Timestamp(((java.util.Date) value).getTime()));
		}
		return super.set(attr, value);
	}

}
