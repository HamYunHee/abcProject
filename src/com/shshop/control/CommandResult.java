package com.shshop.control;

public class CommandResult {
	private String viewURI;
	private String contentType;
	private String content;
	
	public CommandResult(String viewURI) {
		this.viewURI = viewURI;
		this.contentType = null;
		this.content = null;
	}
	
	public CommandResult(String contentType, String content) {
		this.viewURI = null;
		this.contentType = contentType;
		this.content = content;
	}
	
	public String getViewURI() {
		return viewURI;
	}

	public void setViewURI(String viewURI) {
		this.viewURI = viewURI;
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
