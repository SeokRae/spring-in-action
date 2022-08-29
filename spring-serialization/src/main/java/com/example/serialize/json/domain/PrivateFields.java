package com.example.serialize.json.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder(builderClassName = "PrivateFieldsConcretelyBuilder", buildMethodName = "create")
final class PrivateFields {
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private NickName nickName;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private Age age;
	static final PrivateFields EMPTY = new PrivateFields(NickName.EMPTY_NICKNAME, Age.EMPTY);
	
	private PrivateFields() {
	}
	
	public PrivateFields(NickName nickName, Age age) {
		this.nickName = nickName;
		this.age = age;
	}
	
	static PrivateFieldsBuilder usePrivateFields(boolean usePrivateFields) {
		if (!usePrivateFields) {
			return () -> EMPTY;
		}
		return PrivateFields.builder();
	}
	
	static final class PrivateFieldsConcretelyBuilder implements PrivateFieldsBuilder {
	}
}
