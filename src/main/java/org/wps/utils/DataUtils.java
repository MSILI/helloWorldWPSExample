package org.wps.utils;

import org.geoserver.wps.process.StringRawData;

public class DataUtils {
	
	public static StringRawData display(String name, String outputMimeType) {
		
		String hello = "hello " + name+ " !!";
		String result = null;

		if (outputMimeType.equals("application/json") || outputMimeType == null) {
			result = "{\"data\":" + "\"" + hello + "\"}";
		} else {
			result = hello;
		}

		return new StringRawData(result, outputMimeType);
	}
}
