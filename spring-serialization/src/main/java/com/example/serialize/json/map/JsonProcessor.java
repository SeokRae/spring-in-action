package com.example.serialize.json.map;

import com.example.serialize.config.JacksonConfig;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class JsonProcessor {
	
	public static final String CLASSPATH = "classpath:";
	
	public Map readValue(String jsonFileName) {
		try {
			File file = ResourceUtils.getFile(CLASSPATH + "sample_json/" + jsonFileName);
			return JacksonConfig.readValue(file, Map.class);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public <T> T readValue(String jsonFileName, Class<T> clazz) {
		try {
			File file = ResourceUtils.getFile(CLASSPATH + "sample_json/" + jsonFileName);
			return JacksonConfig.readValue(file, clazz);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
