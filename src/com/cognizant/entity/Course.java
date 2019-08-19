/**
 * 
 */
package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Admin
 *
 */
@Entity
@Table(name = "Course")
public class Course {
	@Id
	private long id;
	private String title;
	private String summary;
	public Course() {
	
	}
	
	public Course(long id, String title, String summary) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
	}

	@Column(name = "id",nullable = false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "title",nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "summary",nullable = false)
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", summary=" + summary + "]";
	}
	

}
