package com.example.serialize.interfaces;

import com.example.serialize.interfaces.dto.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/api/v1/events")
public class EventController {
	
	/**
	 * 파라미터로 LocalDateTime 객체를 받는 방식
	 * @param currentDate @DateTimeFormat을 통해 처리 가능
	 * @return
	 */
	@GetMapping
	public ResponseEntity<String> eventTime(
		@RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime currentDate) {
		log.info("currentTime: {}", currentDate);
		return ResponseEntity.ok("SUCCESS");
	}
	
	/**
	 * Event 객체로 역직렬화하는 방식
	 * @param event
	 * @return
	 */
	@PostMapping("/event")
	public ResponseEntity<String> createEvent(@RequestBody Event event) {
		log.info("event: {}", event);
		return ResponseEntity.ok("SUCCESS");
	}
	
	@GetMapping("/event")
	@ResponseBody
	public Event getEvent() {
		return new Event("event", LocalDateTime.now());
	}
}
