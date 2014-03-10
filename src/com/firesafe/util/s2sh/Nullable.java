package com.firesafe.util.s2sh;

@SuppressWarnings("serial")
public class Nullable extends Condition {

	private boolean isNull;

	protected Nullable(String field, boolean isNull) {
		this.field = field;
		this.isNull = isNull;
	}

	public static Nullable isNull(String field) {
		return new Nullable(field, true);
	}

	public static Nullable isNotNull(String field) {
		return new Nullable(field, false);
	}

	public boolean isNull() {
		return isNull;
	}

}
