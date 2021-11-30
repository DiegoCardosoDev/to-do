package com.diego.todo.resource.exeptions;

import java.io.Serializable;

public class StandardError implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Long timestamp;
	private Integer staus;
	private String mensage;

	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardError(Long timestamp, Integer staus, String mensage) {
		super();
		this.timestamp = timestamp;
		this.staus = staus;
		this.mensage = mensage;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStaus() {
		return staus;
	}

	public void setStaus(Integer staus) {
		this.staus = staus;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}

}
