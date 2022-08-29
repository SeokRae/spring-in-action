package com.example.serialize.json.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static com.example.serialize.json.domain.AgeValidator.createOrEmpty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AgeValidatorTest {
	@DisplayName("값의 범위를 제한할 수 있는 RangeCondition을 정의")
	@Test
	void testCase1() {
		Predicate<Integer> condition = AgeValidator.rangeCondition(1, 150);
		assertAll(
			() -> assertThat(condition).isNotNull(),
			() -> assertThat(condition.test(10)).isTrue(),
			() -> assertThat(condition.test(0)).isFalse(),
			() -> assertThat(condition.test(151)).isFalse()
		);
	}
	
	@DisplayName("특정 값 생성 시 범위 체크 메서드 테스트")
	@Test
	void testCase2() {
		AgeValidator validator = createOrEmpty(AgeValidator.rangeCondition(1, 150), -1);
		assertAll(
			() -> assertThat(validator).isNotNull(),
			() -> assertThat(validator.getAge()).isZero()
		);
	}
}