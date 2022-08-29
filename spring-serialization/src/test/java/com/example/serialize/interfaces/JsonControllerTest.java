package com.example.serialize.interfaces;

import com.example.serialize.interfaces.dto.ResponseJson;
import com.example.serialize.intrastructure.dto.ThirdPartyJson;
import com.example.serialize.json.domain.ResponseMember;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.time.LocalDateTime;

@SpringBootTest
class JsonControllerTest {
	
	@Autowired
	private JsonController jsonController;
	
	@Test
	void testCase() throws JsonProcessingException {
		ThirdPartyJson thirdPartyJson = new ThirdPartyJson("name", LocalDateTime.now(), "otherField");
		ResponseEntity<ResponseJson> response = jsonController.getJson(thirdPartyJson);
		ResponseJson body = response.getBody();
		System.out.println("body = " + body);
	}
	
	@DisplayName("요청 필드의 차이에 따라 선택적으로 응답 필드가 달라지는 테스트")
	@ValueSource(strings = {"dynamic_data_03.json","dynamic_data_04.json"})
	@ParameterizedTest(name = "{index} => {0}")
	void testCase2(String filePath) throws IOException {
		ResponseEntity<ResponseMember> member = jsonController.getMember(filePath);
		System.out.println("member = " + member.getBody());
	}
}