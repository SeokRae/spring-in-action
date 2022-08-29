package com.example.serialize.json.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import static com.example.serialize.json.domain.Etc.etc;
import static com.example.serialize.json.domain.PrivateFields.usePrivateFields;

@Slf4j
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMember {
	private final Member member;
	private final PrivateFields privateFields;
	private final Etc etc;
	
	public ResponseMember(Member member, PrivateFields privateFields, Etc etc) {
		this.member = member;
		this.privateFields = privateFields;
		this.etc = etc;
	}
	
	@JsonCreator
	static ResponseMember forJson(
		// member
		@JsonProperty(value = "name", required = true) String name,
		@JsonProperty(value = "email", required = true) String email,
		@JsonProperty(value = "luckyNumber") int luckyNumber,
		
		@JsonProperty("usePrivate") boolean usePrivate,
		// age (optional)
		@JsonProperty(value = "age") int age,
		// nickName (optional)
		@JsonProperty(value = "nickName") String nickName,
		
		// etc
		@JsonProperty(value = "etcValue1") String etcValue1,
		@JsonProperty(value = "etcValue2") String etcValue2,
		@JsonProperty(value = "address") String address
	) {
		return new ResponseMember(
			Member.of(
				name,
				email,
				luckyNumber
			)
			, usePrivateFields(usePrivate)
			.age(Age.optional(age))
			.nickName(NickName.createOrEmpty(nickName))
			.create()
			, etc()
			.put("etcValue1", etcValue1)
			.put("etcValue2", etcValue2)
			.put("address", address)
		);
	}
	
}
