package jsfintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.Collections;

@SpringBootApplication
public class JsfIntegrationApplication {
	public static void main(String[] args) {
		SpringApplication.run(JsfIntegrationApplication.class, args);
	}

	/* Needed to make JSF working */
	@Bean
	public ServletRegistrationBean<FacesServlet> jsfServletRegistration(ServletContext servletContext) {
		/* spring boot only works if this is set */
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

		ServletRegistrationBean<FacesServlet> srb = new ServletRegistrationBean<>();
		srb.setServlet(new FacesServlet());
		srb.setUrlMappings(Collections.singletonList("*.xhtml"));
		srb.setLoadOnStartup(1);

		return srb;
	}
}
