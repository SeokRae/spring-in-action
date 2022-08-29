package com.example.serialize.json.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrivateFieldsTest {
	
	@DisplayName("빈 필드 테스트")
	@Test
	void testCase1() {
		PrivateFields privateFields = PrivateFields
			.usePrivateFields(false)
			.create();
		
		assertThat(privateFields).isEqualTo(PrivateFields.EMPTY);
	}
	
	@DisplayName("usePrivateField값이 false인 경우, 값이 설정 되어도 empty로 처리")
	@Test
	void testCase2() {
		PrivateFields privateFields = PrivateFields
			.usePrivateFields(false)
			.name("seokrae")
			.email("email")
			.age(30)
			.create();
		
		assertThat(privateFields).isEqualTo(PrivateFields.EMPTY);
	}
	
	@DisplayName("usePrivateField값이 true인 경우, 값 설정 정상 조회 테스트")
	@Test
	void testCase3() {
		PrivateFields privateFields = PrivateFields
			.usePrivateFields(true)
			.name("seokrae")
			.email("email")
			.age(30)
			.create();
		
		assertThat(privateFields.getName()).isEqualTo("seokrae");
		assertThat(privateFields.getEmail()).isEqualTo("email");
		assertThat(privateFields.getAge()).isEqualTo(30);
	}
}