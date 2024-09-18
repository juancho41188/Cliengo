package com.space.traffic.controller;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.space.traffic.dto.Payload;
import com.space.traffic.dto.Payloads;
import com.space.traffic.dto.RequestLaunches;
import com.space.traffic.dto.RequestRocket;
import com.space.traffic.dto.ResponseJsonDTO;
import com.space.traffic.dto.RocketResponse;

public class ControllerSpace {
	
	private String HEADER_NAME = "Accept";
	private String HEADER_VALUE = "application/json";
	private String URL_LAUNCHES = "https://api.spacexdata.com/v3/launches";
	private String URL_ROCKETS = "https://api.spacexdata.com/v3/rockets";

	private String spaceLuncherAndRockets(String urlString) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlString)).header(HEADER_NAME, HEADER_VALUE)
				.GET().build();

		String jsonString = null;
		jsonString = client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(response -> {
			return response.body();
		}).join();

		return jsonString;
	}

	public List<ResponseJsonDTO> SpaceTrafficRocketLaunches() {
		List<ResponseJsonDTO> responseJson = new ArrayList<ResponseJsonDTO>();
		String jsonLaunches = spaceLuncherAndRockets(URL_LAUNCHES);
		String jsonRockets = spaceLuncherAndRockets(URL_ROCKETS);
		Gson gson = new Gson();
		Type payloadListTypeLaunches = new TypeToken<List<RequestLaunches>>() {
		}.getType();
		List<RequestLaunches> payloadsLaunches = gson.fromJson(jsonLaunches, payloadListTypeLaunches);

		Type payloadListTypeRocket = new TypeToken<List<RequestRocket>>() {
		}.getType();
		List<RequestRocket> payloadsRocket = gson.fromJson(jsonRockets, payloadListTypeRocket);

		for (RequestLaunches requestLaunches : payloadsLaunches) {
			ResponseJsonDTO response = new ResponseJsonDTO();
			response.setFlight_number(requestLaunches.getFlight_number());
			response.setMission_name(requestLaunches.getMission_name());
			for (RequestRocket requestRocket : payloadsRocket) {
				if (requestRocket.getRocket_id().equals(requestLaunches.getRocket().getRocket_id())) {
					RocketResponse rocket = new RocketResponse();
					rocket.setRocket_id(requestRocket.getRocket_id());
					rocket.setDescription(requestRocket.getDescription());
					rocket.setRocket_name(requestRocket.getRocket_name());
					rocket.setImages(requestRocket.getFlickr_images());
					response.setRocket(rocket);
				}
			}
			List<Payload> payloadList = new ArrayList<Payload>();
			for (Payloads payloads : requestLaunches.getRocket().getSecond_stage().getPayloads()) {

				Payload payload = new Payload();
				payload.setPayload_id(payloads.getPayload_id());
				payload.setManufacturer(payloads.getManufacturer());
				payload.setType(payloads.getPayload_type());
				payloadList.add(payload);
				response.setPayloads(payloadList);
			}
			responseJson.add(response);
		}

		return responseJson;
	}

}
