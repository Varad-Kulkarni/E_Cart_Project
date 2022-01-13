package com.ecome.model;

public class Feedback {
	private int f_id;
	private String email;
	private String feedback_text;
	public Feedback() {
		
	}
	public Feedback(int f_id, String email, String feedback_text) {
		super();
		this.f_id = f_id;
		this.email = email;
		this.feedback_text = feedback_text;
	}
	public Feedback(String email, String feedback_text) {
		super();
		this.email = email;
		this.feedback_text = feedback_text;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFeedback_text() {
		return feedback_text;
	}
	public void setFeedback_text(String feedback_text) {
		this.feedback_text = feedback_text;
	}
	@Override
	public String toString() {
		return "Feedback [f_id=" + f_id + ", email=" + email + ", feedback_text=" + feedback_text + "]";
	}
}
