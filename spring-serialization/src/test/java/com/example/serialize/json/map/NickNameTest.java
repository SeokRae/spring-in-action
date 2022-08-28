package com.example.serialize.json.map;

import com.example.serialize.json.elements.DefaultFields;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.serialize.json.elements.DefaultFields.defaultFields;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * 필수 필드와 옵션 필드를 구분하는 테스트
 */
@Slf4j
@DisplayName("DefaultFields 테스트")
class NickNameTest {
	
	@DisplayName("기본(초기값)필드 객체 생성 테스트")
	@Test
	void testCase1() {
		final DefaultFields<Object> emptyDefaultFields = defaultFields();
		assertAll(
			() -> assertThat(emptyDefaultFields).isNotNull(),
			() -> assertThat(emptyDefaultFields).isInstanceOf(DefaultFields.class)
		);
	}
	
	@DisplayName("기본 값 설정 및 필드 비교 테스트(순서 비교)")
	@Test
	void testCase2() {
		final DefaultFields<Object> defaultFields = defaultFields(0, -1);
		assertThat(defaultFields.is(-1, 0)).isFalse();
		assertThat(defaultFields.is(0, -1)).isTrue();
	}
	
	@DisplayName("기본 값 설정 및 필드 비교 테스트(문자열 비교)")
	@Test
	void testCase3() {
		final DefaultFields<Object> defaultFields = defaultFields("", "");
		assertThat(defaultFields.is(" ", " str")).isFalse();
	}
}