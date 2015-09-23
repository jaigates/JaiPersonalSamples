package com.americanexpress.aboportal.web.controller.wsclient;

public class PlaidBaseResponse {
	private Integer code;
	private String message;
	private String resolve;

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getResolve() {
		return resolve;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResolve(String resolve) {
		this.resolve = resolve;
	}

}
