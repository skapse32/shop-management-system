package com.congdongjava.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "code"))
@NamedQueries({
	@NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")})
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="video_id")
	private Long videoId;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z0-9]{8,12}", message = "message.error.code")
	private String code;
	
	@NotNull
	@Size(min = 6, max = 40, message="message.error.length")
	private String name;
	
	@NotNull
	@URL
	@Column(name="link_value")
	private String linkValue;
	
	@Column(name="view_count")
	private Long viewCount;
	
	@NotNull
	@Column(name="creation_date")
	private Date creationDate;
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(final Long videoId) {
		this.videoId = videoId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getLinkValue() {
		return linkValue;
	}

	public void setLinkValue(final String linkValue) {
		this.linkValue = linkValue;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(final Long viewCount) {
		this.viewCount = viewCount;
	}
}
