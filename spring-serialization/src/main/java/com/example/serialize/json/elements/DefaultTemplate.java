package com.example.serialize.json.elements;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

@ToString
@RequiredArgsConstructor
class DefaultTemplate implements Iterable<String> {
	
	public static final String DELIMITER_SPLIT = ",";
	private final Set<String> templates;
	
	static DefaultTemplate optional(String defaultListTemplate, String defaultFileTemplate) {
		Set<String> templates = Optional.ofNullable(defaultListTemplate) // defaultListTemplate 값이 설정되어 있으면,
			.map(s -> s.split(DELIMITER_SPLIT))                                   // "," 기준으로 split 하고,
			.map(Set::of)                                                    // String[] 에서 중복을 제거하여 불변Set으로 변경
			.orElse(getOther(defaultFileTemplate));
		return new DefaultTemplate(templates);
	}
	
	private static Set<String> getOther(String defaultFileTemplate) {
		return Optional.ofNullable(defaultFileTemplate)   // 혹은, defaultFileTemplate 설정된 경우라면
			.map(Set::of)                               // defaultFileTemplate 값을 첫번째 요소에 넣고,
			.orElse(Collections.emptySet());
	}
	
	@Override
	public Iterator<String> iterator() {
		return templates.iterator();
	}
}