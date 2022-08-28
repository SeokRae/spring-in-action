package com.example.serialize.json.elements;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class DefaultTemplateTest {
	
	@DisplayName("Json의 필드에 빈 배열([])로 초기화 테스트")
	@Test
	void testCase1() {
		DefaultTemplate defaultTemplate = DefaultTemplate.optional(null, null);
		assertAll(
				() -> assertThat(defaultTemplate).isNotNull(),
				() -> assertThat(defaultTemplate).hasToString("DefaultTemplate(templates=[])")
		);
	}
	
	@DisplayName("Json의 단일 컬럼, 멀티 데이터 중복 처리 테스트")
	@Test
	void testCase2() {
		DefaultTemplate defaultTemplate = DefaultTemplate.optional("a, a, b, c", null);
		assertAll(
				() -> assertThat(defaultTemplate).isNotNull(),
				() -> assertThat(defaultTemplate).hasToString("DefaultTemplate(templates=[a, b, c])")
		);
	}
}