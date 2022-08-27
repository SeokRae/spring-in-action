package com.example.serialize.json.map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {
	private String name;
	private String email;
	private int age;
	
	public Member(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}
}
