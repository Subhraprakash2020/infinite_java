package com.java.complaint;

import java.util.Date;

public class Resolve {
	private String ResolveID;
	private String ComplaintID;
	private Date ComplaintDate;
	private Date ResolveDate;
	private String ResolveBy;
	private String Comments;
	public String getResolveID() {
		return ResolveID;
	}
	public void setResolveID(String resolveID) {
		ResolveID = resolveID;
	}
	public String getComplaintID() {
		return ComplaintID;
	}
	public void setComplaintID(String complaintID) {
		ComplaintID = complaintID;
	}
	public Date getComplaintDate() {
		return ComplaintDate;
	}
	public void setComplaintDate(Date complaintDate) {
		ComplaintDate = complaintDate;
	}
	public Date getResolveDate() {
		return ResolveDate;
	}
	public void setResolveDate(Date resolveDate) {
		ResolveDate = resolveDate;
	}
	public String getResolveBy() {
		return ResolveBy;
	}
	public void setResolveBy(String resolveBy) {
		ResolveBy = resolveBy;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	@Override
	public String toString() {
		return "Resolve [ResolveID=" + ResolveID + ", ComplaintID=" + ComplaintID + ", ComplaintDate=" + ComplaintDate
				+ ", ResolveDate=" + ResolveDate + ", ResolveBy=" + ResolveBy + ", Comments=" + Comments + "]";
	}
	public Resolve(String resolveID, String complaintID, Date complaintDate, Date resolveDate, String resolveBy,
			String comments) {
		super();
		ResolveID = resolveID;
		ComplaintID = complaintID;
		ComplaintDate = complaintDate;
		ResolveDate = resolveDate;
		ResolveBy = resolveBy;
		Comments = comments;
	}
	public Resolve() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
