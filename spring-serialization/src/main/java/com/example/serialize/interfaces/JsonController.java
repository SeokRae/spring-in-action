package com.example.serialize.interfaces;

import com.example.serialize.interfaces.dto.ResponseJson;
import com.example.serialize.intrastructure.dto.ThirdPartyJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.serialize.config.JacksonConfig.*;

@RestController
@RequestMapping("/api/v1/json")
public class JsonController {
	
	@PostMapping("/")
	public ResponseEntity<ResponseJson> getJson(@RequestBody ThirdPartyJson thirdPartyJson) throws JsonProcessingException {
		String prettyJson = toPrettyJson(thirdPartyJson);
		ThirdPartyJson thirdPartyJson1 = fromJson(prettyJson, ThirdPartyJson.class);
		System.out.println("thirdPartyJson1 = " + thirdPartyJson1);
		
		ResponseJson responseJson = convertValue(thirdPartyJson1, ResponseJson.class);
		System.out.println("responseJson = " + responseJson);
		return ResponseEntity.ok(responseJson);
	}
}
