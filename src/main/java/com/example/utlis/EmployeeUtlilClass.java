package com.example.utlis;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
//@PropertySource("classpath:/message.properties")
//@PropertySource("file:/src/main/resources/message.properties")
public class EmployeeUtlilClass {

	@Autowired
	MessageSource messagesource;
	
	
	
	public String getmessage(String message, Object [] arr)
	{
		return messagesource.getMessage(message, arr, Locale.US);
	}


}
