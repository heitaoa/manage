package com.poly.upload;

public class InvalidFile {
	private String message;

	private String fileName;

	public InvalidFile(String message, String fileName) {
		this.message = message;
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
