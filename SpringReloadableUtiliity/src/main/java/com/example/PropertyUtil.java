package com.example;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;

@Service
public class PropertyUtil implements MessageSource {
 
	@Resource(name="propertyUtil")
	MessageSource myProperties;

	public String getProperty(String key) {
		//TODO:to automatically find locale
		String value = myProperties.getMessage(key, null, null);
		return value;
	}

	public String getMessage(String paramString1, Object[] paramArrayOfObject, String paramString2, Locale paramLocale) {
		return myProperties.getMessage(paramString1, paramArrayOfObject, paramString2, paramLocale);
	}

	public String getMessage(String paramString, Object[] paramArrayOfObject, Locale paramLocale) throws NoSuchMessageException {
		return getMessage(paramString, paramArrayOfObject, paramLocale);
	}

	public String getMessage(MessageSourceResolvable paramMessageSourceResolvable, Locale paramLocale) throws NoSuchMessageException {
		return getMessage(paramMessageSourceResolvable, paramLocale);
	}

}
