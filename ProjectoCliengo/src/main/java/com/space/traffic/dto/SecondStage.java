package com.space.traffic.dto;

import java.util.List;

public class SecondStage {

	private List<Payloads> payloads;
	private int block;

	public List<Payloads> getPayloads() {
		return payloads;
	}

	public void setPayloads(List<Payloads> payloads) {
		this.payloads = payloads;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}
}
