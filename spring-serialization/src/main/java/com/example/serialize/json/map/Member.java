package com.example.serialize.json.map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Address;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {
	private String name;
	private String email;
	private int age;
	private NickName nickName;
	
	public Member(String name, String email, int age, NickName nickName) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.nickName = nickName;
	}
	
	public Member of(String name, String email, int age, NickName nickName) {
		return new Member(name, email, age, nickName);
	}
}
