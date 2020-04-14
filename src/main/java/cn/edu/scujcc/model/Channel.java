package cn.edu.scujcc.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Channel {
    @Id
	private String id;
    private String title;
	private String quality;
	private String url;
	private List<Conment> conment;
	
	
	public List<Conment> getConment() {
		return conment;
	}
	public void setConment(List<Conment> conment) {
		this.conment = conment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quality == null) ? 0 : quality.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Channel other = (Channel) obj;
		if (quality == null) {
			if (other.quality != null)
				return false;
		} else if (!quality.equals(other.quality))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	public String getId() {
		return id;
	}
	public void setId(String i) {
		this.id = i;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Channel [id=" + id + ", title=" + title + ", quality=" + quality + ", url=" + url + "]";
	}
	
}
