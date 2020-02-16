package com.miles.lottery.bean;

import java.io.Serializable;

public class StudentDto implements Serializable {

	private static final long serialVersionUID = -3787026147688297200L;

	private String uid;
	private String uname;
	private String uno;
	private Double score;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUno() {
		return uno;
	}

	public void setUno(String uno) {
		this.uno = uno;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}
