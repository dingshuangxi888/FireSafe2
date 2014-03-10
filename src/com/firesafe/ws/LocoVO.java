package com.firesafe.ws;

public class LocoVO {

	private long imsi;
	private double lat;
	private double lon;
	private double cep;
	private double alt;
	private short bl;
	private short tamper;
	private short temperature;
	private short speed;
	private int type;
	private long time;

	public long getImsi() {
		return imsi;
	}

	public void setImsi(long imsi) {
		this.imsi = imsi;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getCep() {
		return cep;
	}

	public void setCep(double cep) {
		this.cep = cep;
	}

	public double getAlt() {
		return alt;
	}

	public void setAlt(double alt) {
		this.alt = alt;
	}

	public short getBl() {
		return bl;
	}

	public void setBl(short bl) {
		this.bl = bl;
	}

	public short getTamper() {
		return tamper;
	}

	public void setTamper(short tamper) {
		this.tamper = tamper;
	}

	public short getTemperature() {
		return temperature;
	}

	public void setTemperature(short temperature) {
		this.temperature = temperature;
	}

	public short getSpeed() {
		return speed;
	}

	public void setSpeed(short speed) {
		this.speed = speed;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
}
