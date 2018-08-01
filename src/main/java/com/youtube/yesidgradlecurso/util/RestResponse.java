package com.youtube.yesidgradlecurso.util;

public class RestResponse {

	private Integer responseCode;
	private String message;
	
	
	public RestResponse(Integer responseCode) {
		super();
		this.responseCode = responseCode;
	}
	
	public RestResponse(Integer responseCode, String message) {
		super();
		this.responseCode = responseCode;
		this.message = message;
	}
	
	public Integer getCodigoRespuesta() {
		return responseCode;
	}
	public void setCodigoRespuesta(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getMensaje() {
		return message;
	}
	public void setMensaje(String message) {
		this.message = message;
	}
	
}
