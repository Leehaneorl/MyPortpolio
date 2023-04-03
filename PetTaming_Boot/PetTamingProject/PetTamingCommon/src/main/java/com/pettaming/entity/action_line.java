package com.pettaming.entity;

import java.util.List;

public class action_line {

	private int y_axis;
	
	private List<String> x_axis;

	public action_line() {
	}

	public action_line(int y_axis, List<String> x_axis) {
		super();
		this.y_axis = y_axis;
		this.x_axis = x_axis;
	}

	public int getY_axis() {
		return y_axis;
	}

	public void setY_axis(int y_axis) {
		this.y_axis = y_axis;
	}

	public List<String> getX_axis() {
		return x_axis;
	}

	public void setX_axis(List<String> x_axis) {
		this.x_axis = x_axis;
	} 
	
	
}
