package com.example.serialize.json.map;

import com.example.serialize.config.JacksonConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@Slf4j
class JsonProcessorTest {
	
	private JsonProcessor processor;
	
	@BeforeEach
	void setUp() {
		processor = new JsonProcessor();
	}
	
	@Nested
	@DisplayName("Map to Json")
	class JsonToMap {
		@DisplayName("데이터 파싱할 때, Map 자료형을 사용하게 되면 불편한 점")
		@ValueSource(strings = {"dynamic_data_01.json", "dynamic_data_02.json"})
		@ParameterizedTest(name = "{0}")
		void testCase1(String jsonFile) {
			final Map jsonMap = processor.readValue(jsonFile);
			final Object age = jsonMap.getOrDefault("age", 0);
			log.debug(
				"\n [age type check] \n - age instanceof Long => result : {} \n - age instanceof Integer => result : {}"
				, age instanceof Long, age instanceof Integer
			);
			if (age instanceof Integer) {
				int i = (Integer) age;
				if (30 < i) {
					log.info("테스트 결과 출력 : {}", i);
				}
			}
		}
	}
	
	@Nested
	@DisplayName("Json to Object")
	class JsonToObject {
		@DisplayName("데이터를 역직렬화할 때 정상 처리되는 사례")
		@ParameterizedTest
		@ValueSource(strings = {"dynamic_data_01.json", "dynamic_data_02.json"})
		void testCase1(String jsonFileName) {
			final Member member = processor.readValue(jsonFileName, Member.class);
			final int i = member.getAge();
			log.debug(
				"\n[age type check]" +
					"\n - result : {}", i
			);
			if (30 < i) {
				log.info("테스트 결과 출력 : {}", i);
			}
		}
		
		@DisplayName("Json 데이터를 역직렬화할 때 발생할 수 있는 문제점 - 자료형")
		@ParameterizedTest
		@ValueSource(strings = {"dynamic_data_03.json"})
		void testCase2(String jsonFileName) {
			assertThatExceptionOfType(JacksonConfig.JsonConvertException.class)
				.isThrownBy(() -> processor.readValue(jsonFileName, Member.class));
		}
	}
	
}