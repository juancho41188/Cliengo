package com.space.traffic.dto;

import java.util.List;

public class RocketResponse {

	private String rocket_id;
	private String rocket_name;
	private String description;
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

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
}
