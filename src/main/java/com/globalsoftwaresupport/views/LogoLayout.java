package com.globalsoftwaresupport.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class LogoLayout extends HorizontalLayout{

	
	private Image image;
	
	public LogoLayout() {
		image = new Image("images/tech_logo.png", "My Image");
		
		setJustifyContentMode(JustifyContentMode.CENTER);
		
		add(image);
	}
}
