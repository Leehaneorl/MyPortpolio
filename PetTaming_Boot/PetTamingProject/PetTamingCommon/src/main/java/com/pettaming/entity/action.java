package com.pettaming.entity;

import java.util.List;

public class action {
	
	private List<action_line> x_axis_line;

	public action() {
	}

	public action(List<action_line> x_axis_line) {
		super();
		this.x_axis_line = x_axis_line;
	}



	public List<action_line> getX_axis_line() {
		return x_axis_line;
	}

	public void setX_axis_line(List<action_line> x_axis_line) {
		this.x_axis_line = x_axis_line;
	}
	
}
