package com.care.ajax;
/*
	CREATE TABLE ajax(
	title varchar2(30),
	artist varchar2(20),
	price varchar2(10)
	);
	
	commit;
	
 */

public class AjaxDTO {
	private String title;
	private String artist;
	private String price;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
