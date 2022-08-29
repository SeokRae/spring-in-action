package com.example.serialize.json.domain;

interface PrivateFieldsBuilder {
	
	default PrivateFieldsBuilder name(String name) {
		return this;
	}
	
	default PrivateFieldsBuilder email(String email) {
		return this;
	}
	
	default PrivateFieldsBuilder age(int age) {
		return this;
	}
	
	PrivateFields create();
}
