package com.king.timenotes.jdbc.entity;

public class Note {
	private String title;
	private String content;
    private String datetime;
    private String username;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	 @Override
	    public String toString() {
	        return "Note{" +
	                "title='" + title + '\'' +
	                ", content='" + content + '\'' +
	                ", datetime='" + datetime + '\'' +
	                '}';
	    }

    
}
