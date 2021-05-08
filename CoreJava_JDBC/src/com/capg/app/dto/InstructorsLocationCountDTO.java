package com.capg.app.dto;

public class InstructorsLocationCountDTO implements Comparable<InstructorsLocationCountDTO>{
	private String location;
	private int count;
	public InstructorsLocationCountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InstructorsLocationCountDTO(String location, int count) {
		super();
		this.location = location;
		this.count = count;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int compareTo(InstructorsLocationCountDTO o) {
		return this.count - o.count;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Instructor: Count: "+count+" Location: "+location;
	}
    
}
