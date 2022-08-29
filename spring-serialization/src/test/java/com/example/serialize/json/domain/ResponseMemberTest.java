package com.example.serialize.json.domain;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;

@Slf4j
@JsonTest
class ResponseMemberTest {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@BeforeEach
	void setUp() {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.disable(FAIL_ON_EMPTY_BEANS);
	}
	
	@DisplayName("전체 적용 테스트")
	@ValueSource(strings = {"dynamic_data_03.json","dynamic_data_04.json"})
	@ParameterizedTest(name = "{index} => {0}")
	void testCase1(String filePath) throws IOException {
		final File file = ResourceUtils.getFile("classpath:sample_json/" + filePath);
		final var map = objectMapper.readValue(file, ResponseMember.class);
		log.debug("{}", map);
		String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		log.debug("\n{}", value);
	}
}