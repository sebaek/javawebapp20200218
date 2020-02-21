package app.bean;

import java.sql.Date;

public class Board {
	private long id;
	private String memberId;
	private String title;
	private String body;
	private Date inserted;
	private String fileName;
	
	
	
	@Override
	public String toString() {
		return "Board [id=" + id + ", memberId=" + memberId + ", title=" + title + ", body=" + body + ", inserted="
				+ inserted + ", fileName=" + fileName + ", getFileName()=" + getFileName() + ", getId()=" + getId()
				+ ", getMemberId()=" + getMemberId() + ", getTitle()=" + getTitle() + ", getBody()=" + getBody()
				+ ", getInserted()=" + getInserted() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getInserted() {
		return inserted;
	}
	public void setInserted(Date inserted) {
		this.inserted = inserted;
	}
	
	
}
