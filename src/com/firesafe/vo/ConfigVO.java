package com.firesafe.vo;

public class ConfigVO {

	private long deviceid;
	private String name;
	private int tarcep;
	private int wkp;
	private String apn;
	private String dns;
	private int prt;
	private int tgps;
	private int tenbl = -1;
	private int e433 = -1;
	private int tempenable = -1;
	private int speedenable = -1;

	public long getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTarcep() {
		return tarcep;
	}

	public void setTarcep(int tarcep) {
		this.tarcep = tarcep;
	}

	public int getWkp() {
		return wkp;
	}

	public void setWkp(int wkp) {
		this.wkp = wkp;
	}

	public String getApn() {
		return apn;
	}

	public void setApn(String apn) {
		this.apn = apn;
	}

	public String getDns() {
		return dns;
	}

	public void setDns(String dns) {
		this.dns = dns;
	}

	public int getPrt() {
		return prt;
	}

	public void setPrt(int prt) {
		this.prt = prt;
	}

	public int getTgps() {
		return tgps;
	}

	public void setTgps(int tgps) {
		this.tgps = tgps;
	}

	public int getTenbl() {
		return tenbl;
	}

	public void setTenbl(int tenbl) {
		this.tenbl = tenbl;
	}

	public int getE433() {
		return e433;
	}

	public void setE433(int e433) {
		this.e433 = e433;
	}

	public int getTempenable() {
		return tempenable;
	}

	public void setTempenable(int tempenable) {
		this.tempenable = tempenable;
	}

	public int getSpeedenable() {
		return speedenable;
	}

	public void setSpeedenable(int speedenable) {
		this.speedenable = speedenable;
	}
}
