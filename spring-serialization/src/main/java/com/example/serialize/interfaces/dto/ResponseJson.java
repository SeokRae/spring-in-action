package com.example.serialize.interfaces.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseJson {
	private String name;
	private LocalDateTime responseDate;
	
	public ResponseJson(String name, LocalDateTime responseDate) {
		this.name = name;
		this.responseDate = responseDate;
	}
	
	@Override
	public String toString() {
		return "ResponseJson{" +
			"name='" + name + '\'' +
			", responseDate=" + responseDate +
			'}';
	}
}
