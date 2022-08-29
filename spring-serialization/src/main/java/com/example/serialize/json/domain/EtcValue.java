package com.example.serialize.json.domain;

final class EtcValue {
	private final int intValue;
	private final String strValue;
	
	static final int EMPTY_INT = Integer.MIN_VALUE;
	static final String EMPTY_STR = "${EMPTY_STRING}";
	
	static final EtcValue empty = new EtcValue(EMPTY_INT, EMPTY_STR);
	
	EtcValue(int intValue, String strValue) {
		this.intValue = intValue;
		this.strValue = strValue;
	}
	
	static EtcValue intValue(int intValue) {
		return new EtcValue(intValue, EMPTY_STR);
	}
	
	static EtcValue strValue(String strValue) {
		return new EtcValue(EMPTY_INT, strValue);
	}
	
	int getInt() {
		return intValue;
	}
	
	String getString() {
		return strValue;
	}
	
	@Override
	public String toString() {
		if (EMPTY_INT != intValue) {
			return "" + intValue;
		}
		if (!EMPTY_STR.equals(strValue)) {
			return strValue;
		}
		return "";
	}
}
