package com.jsoup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class NewsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "title")
	private String title;
	@Column(name = "url")
	private String url;
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	@Column(name = "posttime")
	private String postTime;

	@ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "webname_id")
	private WebNameEntity webname;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	public WebNameEntity getWebname() {
		return webname;
	}

	public void setWebname(WebNameEntity webname) {
		this.webname = webname;
	}

	public Long getId() {
		return id;
	}
}
