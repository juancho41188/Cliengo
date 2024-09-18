package com.space.traffic.dto;

import java.util.List;

public class Rocket {
	private String rocket_id;
	private String rocket_name;
	private String description;
	private SecondStage second_stage;
	private List<String> images;

	public String getRocket_id() {
		return rocket_id;
	}

	public void setRocket_id(String rocket_id) {
		this.rocket_id = rocket_id;
	}

	public String getRocket_name() {
		return rocket_name;
	}

	public void setRocket_name(String rocket_name) {
		this.rocket_name = rocket_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SecondStage getSecond_stage() {
		return second_stage;
	}

	public void setSecond_stage(SecondStage second_stage) {
		this.second_stage = second_stage;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

}
