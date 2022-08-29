package com.example.serialize.interfaces;

import com.example.serialize.config.JacksonConfig;
import com.example.serialize.interfaces.dto.ResponseJson;
import com.example.serialize.intrastructure.dto.ThirdPartyJson;
import com.example.serialize.json.domain.ResponseMember;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

import static com.example.serialize.config.JacksonConfig.*;

@Slf4j
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
	
	@GetMapping("/")
	public ResponseEntity<ResponseMember> getMember(@RequestParam String filePath) throws IOException {
		final File file = ResourceUtils.getFile("classpath:sample_json/" + filePath);
		final var map = JacksonConfig.readValue(file, ResponseMember.class);
		log.debug("map = {}", map);
		return ResponseEntity.ok(map);
	}
}
