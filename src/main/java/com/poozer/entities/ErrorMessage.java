package com.poozer.entities;

public class ErrorMessage implements Message {
	private String message;
    private boolean isError;
	public ErrorMessage(String message) {
		this.message = message;
		this.isError = true;
	}


	public boolean getIsError() {
		return isError;
	}


	public void setError(boolean isError) {
		this.isError = isError;
	}


	@Override
	public String getMessage() {
		return message;
	}

}
