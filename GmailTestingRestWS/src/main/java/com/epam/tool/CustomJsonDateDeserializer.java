package com.epam.tool;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class CustomJsonDateDeserializer  extends JsonDeserializer<Date>{
 
	@Override
	public Date deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {
			DateFormat format = new SimpleDateFormat("MMM d, yyyy hh:mm:ss aa");
	        String date = jsonparser.getText();
	        try {
	            return format.parse(date);
	        } catch (ParseException e) {
	            throw new RuntimeException(e);
	        }
	}
}
