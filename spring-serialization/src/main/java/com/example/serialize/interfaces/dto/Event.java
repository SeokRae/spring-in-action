package com.example.serialize.interfaces.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Event {
	private String name;
	private LocalDateTime eventDate;
	
	public Event(String name, LocalDateTime eventDate) {
		this.name = name;
		this.eventDate = eventDate;
	}
	
	@Override
	public String toString() {
		return "Event{" +
			"name='" + name + '\'' +
			", eventDate=" + eventDate +
			'}';
	}
}
