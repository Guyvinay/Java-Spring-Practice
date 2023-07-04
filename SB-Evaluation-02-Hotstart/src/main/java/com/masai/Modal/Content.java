package com.masai.Modal;

import java.util.Objects;

/*
 * contentId (unique identifier)
title
description
category
duration
 */

public class Content {

	private int contentId;
	private String title;
	private String description;
	private double duration;
	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Content(int contentId, String title, String description, double duration) {
		super();
		this.contentId = contentId;
		this.title = title;
		this.description = description;
		this.duration = duration;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(contentId, description, duration, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Content other = (Content) obj;
		return contentId == other.contentId && Objects.equals(description, other.description)
				&& Double.doubleToLongBits(duration) == Double.doubleToLongBits(other.duration)
				&& Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Content [contentId=" + contentId + ", title=" + title + ", description=" + description + ", duration="
				+ duration + "]";
	}
	
	
}
