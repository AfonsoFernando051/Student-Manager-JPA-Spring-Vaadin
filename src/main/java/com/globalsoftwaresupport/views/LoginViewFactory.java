package com.globalsoftwaresupport.views;

import org.springframework.stereotype.Component;

import com.globalsoftwaresupport.constants.Constants;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

@Component
public class LoginViewFactory {

	private class LoginForm{
		private VerticalLayout root;
		private TextField username;
		private PasswordField password;
		private Button login;
		private Button signup;

		public LoginForm init() {
						
			username = new TextField("Username");
			password = new PasswordField("Password");

			login = new Button("Login");
			signup = new Button("Signup");

			login.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			signup.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

			root = new VerticalLayout();
			root.setAlignItems(Alignment.CENTER);
			root.setJustifyContentMode(JustifyContentMode.CENTER);
			root.setMargin(true);
			
			return this;
		}
		
		public com.vaadin.flow.component.Component layout() {
			root.add(new Image(Constants.LOGIN_IMAGE_URL, ""));
			root.add(username);
			root.add(password);
			root.add(new HorizontalLayout(login, signup));
			return root;
		}
	}
	
	public com.vaadin.flow.component.Component create() {
		return new LoginForm().init().layout();
	}
}
