package com.example.serialize.json.domain;


import lombok.*;

@Getter
@ToString
@Builder(builderClassName = "PrivateFieldsConcretelyBuilder", buildMethodName = "create")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
final class PrivateFields {
	private final String name;
	private final String email;
	private final int age;
	
	static final PrivateFields EMPTY = new PrivateFields("", "", 0);
	
	static PrivateFieldsBuilder usePrivateFields(boolean usePrivateFields) {
		if(!usePrivateFields) {
			return () -> EMPTY;
		}
		return PrivateFields.builder();
	}
	
	static final class PrivateFieldsConcretelyBuilder implements PrivateFieldsBuilder { }
}
