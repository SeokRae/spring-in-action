package com.example.serialize.json.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
	private String name;
	private String email;
	private int luckyNumber;
	
	public Member(String name, String email, int luckyNumber) {
		this.name = name;
		this.email = email;
		this.luckyNumber = luckyNumber;
	}
	
	public static Member of(String name, String email, int luckyNumber) {
		return new Member(name, email, luckyNumber);
	}
	
}
