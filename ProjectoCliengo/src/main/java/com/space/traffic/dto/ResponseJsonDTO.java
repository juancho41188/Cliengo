package com.space.traffic.dto;

import java.util.List;

public class ResponseJsonDTO {

	private long flight_number;
	private String mission_name;
	private RocketResponse rocket;
	private List<Payload> payloads;

	public long getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(long flight_number) {
		this.flight_number = flight_number;
	}

	public String getMission_name() {
		return mission_name;
	}

	public void setMission_name(String mission_name) {
		this.mission_name = mission_name;
	}

	public RocketResponse getRocket() {
		return rocket;
	}

	public void setRocket(RocketResponse rocket) {
		this.rocket = rocket;
	}

	public List<Payload> getPayloads() {
		return payloads;
	}

	public void setPayloads(List<Payload> payloads) {
		this.payloads = payloads;
	}

}
