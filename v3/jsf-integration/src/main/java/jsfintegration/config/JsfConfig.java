package jsfintegration.config;

import jakarta.faces.webapp.FacesServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsfConfig {
	@Bean
	public ServletRegistrationBean<FacesServlet> facesServletRegistration() {
		return new ServletRegistrationBean<>(new FacesServlet(), "*.jsf");
	}
}
