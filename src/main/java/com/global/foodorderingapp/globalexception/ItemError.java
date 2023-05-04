package com.global.foodorderingapp.globalexception;

public class ItemError {

	private Integer errorCode;
	private String erroDesc;

	public ItemError(Integer errorCode, String erroDesc) {
			super();
			this.errorCode = errorCode;
			this.erroDesc = erroDesc;
		}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErroDesc() {
		return erroDesc;
	}

	public void setErroDesc(String erroDesc) {
		this.erroDesc = erroDesc;
	}

}
