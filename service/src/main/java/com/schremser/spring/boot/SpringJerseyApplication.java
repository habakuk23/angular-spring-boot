package com.schremser.spring.boot;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * tutorial from
 * http://geowarin.github.io/a-simple-spring-boot-and-jersey-application.html
 * https://github.com/geowarin/springboot-jersey
 *
 * implemented with Love
 */
@SpringBootApplication
@EnableAutoConfiguration
public class SpringJerseyApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringJerseyApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}

	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new ServletContainer(), "/api/*");
		registrationBean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return registrationBean;
	}
}
