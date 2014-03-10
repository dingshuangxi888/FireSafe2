package com.firesafe.vo;

public class DevConfigsVO {

	private String status;
	private ConfigVO current;
	private ConfigVO modified;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ConfigVO getCurrent() {
		return current;
	}

	public void setCurrent(ConfigVO current) {
		this.current = current;
	}

	public ConfigVO getModified() {
		return modified;
	}

	public void setModified(ConfigVO modified) {
		this.modified = modified;
	}

}
