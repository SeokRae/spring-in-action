package com.example.serialize.intrastructure.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ThirdPartyJson {
	private String name;
	private LocalDateTime eventDate;
	
	private String otherField;
	
	public ThirdPartyJson(String name, LocalDateTime eventDate, String otherField) {
		this.name = name;
		this.eventDate = eventDate;
		this.otherField = otherField;
	}
	
	@Override
	public String toString() {
		return "ThirdPartyJson{" +
			"name='" + name + '\'' +
			", eventDate=" + eventDate +
			", otherField='" + otherField + '\'' +
			'}';
	}
}
