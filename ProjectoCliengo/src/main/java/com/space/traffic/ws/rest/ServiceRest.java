package com.space.traffic.ws.rest;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.space.traffic.controller.ControllerSpace;
import com.space.traffic.dto.ResponseJsonDTO;

@RestController
public class ServiceRest {

	@GetMapping("/SpaceTraffic/test")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ResponseJsonDTO> traficoEspacial() {
		ResponseJsonDTO res = new ResponseJsonDTO();
		res.setFlight_number(4);
		res.setMission_name("prueba 1");
		ControllerSpace controllerSpace = new ControllerSpace();
		
		
		return controllerSpace.SpaceTrafficRocketLaunches();
	}

}
