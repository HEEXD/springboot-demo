package com.hxd.springbootdemo.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult {

	private int code;

	private String message;

	private Map<String, Object> details;

	public CommonResult(int code, String message) {
		this.code = code;
		this.message = message;
		this.details = new HashMap<>();
	}

	public <T> CommonResult withDetails(String key, T value) {
		details.put(key, value);
		return this;
	}
}
