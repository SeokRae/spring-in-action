package com.example.serialize.json.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {
	private String name;
	private String email;
	private Age age;
	private NickName nickName;
	
	public Member(String name, String email, int age, NickName nickName) {
		this.name = name;
		this.email = email;
		this.age = Age.optional(age);
		this.nickName = nickName;
	}
	
	public Member of(String name, String email, int age, NickName nickName) {
		return new Member(name, email, age, nickName);
	}
	
	public int getAge() {
		return age.value();
	}
}
