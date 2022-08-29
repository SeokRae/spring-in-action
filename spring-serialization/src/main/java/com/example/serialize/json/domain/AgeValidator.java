package com.example.serialize.json.domain;

import java.util.function.Predicate;

/**
 * 특정 값에 대한 range를 Validation 처리하는 클래스
 */
final class AgeValidator {
	
	private static final int ZERO = 0;
	private static final AgeValidator empty = new AgeValidator(ZERO);
	private final int value;
	
	AgeValidator(int value) {
		this.value = value;
	}
	
	static AgeValidator createOrEmpty(Predicate<Integer> range, int value) {
		if (!range.test(value)) {
			return empty;
		}
		return new AgeValidator(value);
	}
	
	static Predicate<Integer> lowerRange(final int lower) {
		return (c) -> lower <= c;
	}
	
	static Predicate<Integer> higherRange(final int higher) {
		return (c) -> higher >= c;
	}
	
	
	static Predicate<Integer> rangeCondition(final int lower, final int higher) {
		return lowerRange(lower).and(higherRange(higher));
	}
	
	public int getAge() {
		return value;
	}
}