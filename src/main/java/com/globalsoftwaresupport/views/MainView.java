package com.globalsoftwaresupport.views;

import java.util.ArrayList;
import java.util.List;

import com.globalsoftwaresupport.model.Status;
import com.globalsoftwaresupport.model.Student;
import com.globalsoftwaresupport.services.StudentService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle(value = "Home")
@Route(value = "")
public class MainView extends VerticalLayout{
	
	private final StudentService studentService;
	private LogoLayout logoLayout;
	private Grid<Student> grid;
	private TextField filterField;
	
	public MainView(StudentService studentService) {
		this.studentService = studentService;
		setSizeFull();
		setAlignItems(Alignment.CENTER);
		
		createFieldVariables();
		configureGrid();
		
		loadStudents();
		add(logoLayout, createToolBar(),grid);
	}
	
	private Component createToolBar() {
		filterField.setPlaceholder("Filter by name...");
		filterField.setClearButtonVisible(true);
		filterField.setValueChangeMode(ValueChangeMode.LAZY);
		filterField.addValueChangeListener(e -> updateStudents());
		return new HorizontalLayout(filterField);
	}

	private void updateStudents() {
		grid.setItems(studentService.find(filterField.getValue()));
	}

	private void configureGrid() {
		grid.setSizeFull();
		grid.setColumns("country", "zipCode");
		grid.addColumn(s -> s.getName()).setHeader("Name");
		grid.addColumn(s -> s.getAge()).setHeader("Age");

		grid.addComponentColumn(s -> {
			Icon icon;
			
			if(s.getStatus().getName().equals("ATIVO")) {
				icon = VaadinIcon.CIRCLE.create();
				icon.setColor("green");
			}else if(s.getStatus().getName().equals("PASSIVO")) {
				icon = VaadinIcon.CLOSE_CIRCLE.create();
				icon.setColor("red");
			}else{
				icon = VaadinIcon.CHECK_CIRCLE.create();
				icon.setColor("orange");
			}
			
			return icon;
		}).setHeader("Status");
		
		grid.getColumns().forEach(col -> col.setAutoWidth(true));

	}

	private void loadStudents() {
		grid.setItems(studentService.findAll());
	}
	
	private void createFieldVariables() {
		this.logoLayout = new LogoLayout();
		this.grid = new Grid<>(Student.class);
		this.filterField = new TextField();
	}
}
