package com.poozer.entities;

public class NotificationMessage implements Message {
	private String message;
	private boolean isError;
	public NotificationMessage(String message) {
		this.message = message;
		this.isError = false;
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
