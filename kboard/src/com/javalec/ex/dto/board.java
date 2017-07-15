package com.javalec.ex.dto;

import java.sql.Timestamp;

public class board {
	
	private int bid;
	private String b_name;
	private String b_title;
	private String b_content;
	private Timestamp b_date;
	private int b_hit;
	private int b_group;
	private int b_step;
	private int b_indent;
	
	public board(int bid, String bname, String btitle, String bcontent, Timestamp bdate, int bhit,
			int bgroup, int bstep, int bindent) {
		// TODO Auto-generated constructor stub
	    this.bid=bid;
		this.b_name=bname;
		this.b_title=btitle;
		this.b_content=bcontent;
		this.b_date=bdate;
		this.b_hit=bhit;
		this.b_group=bgroup;
		this.b_step=bstep;
		this.b_indent=bindent;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Timestamp getB_date() {
		return b_date;
	}
	public void setB_date(Timestamp b_date) {
		this.b_date = b_date;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public int getB_group() {
		return b_group;
	}
	public void setB_group(int b_group) {
		this.b_group = b_group;
	}
	public int getB_step() {
		return b_step;
	}
	public void setB_step(int b_step) {
		this.b_step = b_step;
	}
	public int getB_indent() {
		return b_indent;
	}
	public void setB_indent(int b_indent) {
		this.b_indent = b_indent;
	}
	
}
 