package com.gmailtesting.tools;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
	
	private static String FORMAT_TIME_FULL = "yyyy-MM-dd"; 
	
	public static Date formatDate(Long time){
		Date dateOld = new Date(time);
		Date dateNew = null;
		Format format = new SimpleDateFormat(FORMAT_TIME_FULL);
		String dateNewString = format.format(dateOld);
		try {
			dateNew =  new SimpleDateFormat().parse(dateNewString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateNew;
	}
	
	public static void main(String[] args) {
		formatDate(new Date().getTime());
	}

}
