package com.viacom.vengal.newsfeed;

/**
 * A representation of an rss item from the list.
 * 
 * @author VengalaRao Pachva
 * 
 */
public class RssItem {

	private final String title;
	private final String link;

	public RssItem(String title, String link) {
		this.title = title;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}
}
