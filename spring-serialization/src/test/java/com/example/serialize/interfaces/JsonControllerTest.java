package com.example.serialize.interfaces;

import com.example.serialize.interfaces.dto.ResponseJson;
import com.example.serialize.intrastructure.dto.ThirdPartyJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

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
}