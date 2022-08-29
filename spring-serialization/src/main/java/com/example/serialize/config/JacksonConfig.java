package com.example.serialize.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class JacksonConfig {
	
	private JacksonConfig() {
	}
	
	private static final ObjectMapper OBJECT_MAPPER;
	
	static {
		OBJECT_MAPPER = new ObjectMapper();
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		javaTimeModule.addDeserializer(ZonedDateTime.class, InstantDeserializer.ZONED_DATE_TIME);
		javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));
		javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));
		
		OBJECT_MAPPER.registerModule(javaTimeModule);
		OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}
	
	public static ObjectMapper getObjectMapper() {
		return OBJECT_MAPPER;
	}
	
	public static <T> T fromJson(String json, Class<T> clazz) {
		if (Objects.isNull(json)) {
			return null;
		}
		
		try {
			return OBJECT_MAPPER.readValue(json, clazz);
		} catch (IOException ioe) {
			throw new JsonReadException(ioe);
		}
	}
	
	public static String toPrettyJson(final Object source) {
		if (Objects.isNull(source)) {
			return "null";
		}
		
		try {
			return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(source);
		} catch (IOException ioe) {
			throw new JsonWriteException(ioe);
		}
	}
	
	public static <T> T readValue(JsonParser p, TypeReference<T> valueTypeRef) {
		try {
			return OBJECT_MAPPER.readValue(p, valueTypeRef);
		} catch (IOException e) {
			throw new JsonReadException(e);
		}
	}
	
	public static <T> T readValue(File file, Class<T> valueType) {
		try {
			return OBJECT_MAPPER.readValue(file, valueType);
		} catch (IOException e) {
			throw new JsonConvertException(e);
		}
	}
	
	public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
		return OBJECT_MAPPER.convertValue(fromValue, toValueType);
	}
	
	public static class JsonWriteException extends RuntimeException {
		public JsonWriteException(Throwable cause) {
			super(cause);
		}
	}
	
	public static class JsonReadException extends RuntimeException {
		public JsonReadException(Throwable cause) {
			super(cause);
		}
	}
	
	public static class JsonConvertException extends RuntimeException {
		public JsonConvertException(Throwable cause) {
			super(cause);
		}
	}
}
