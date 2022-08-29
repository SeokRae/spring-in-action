package com.example.serialize.json.domain;

interface PrivateFieldsBuilder {
	
	default PrivateFieldsBuilder nickName(NickName nickName) {
		return this;
	}
	
	default PrivateFieldsBuilder age(Age age) {
		return this;
	}
	
	PrivateFields create();
}
