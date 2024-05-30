package dev.danvega.runnerz;

import dev.danvega.runnerz.user.UserHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Boilerplate for setting up Rest Client and tell Spring this is the user HTTP client and I need you to create this for me.
	// HTTP Interface - The Spring Frameworks lets you define an HTTP service as a Java interface with HTTP exchange methods (similar to how we define repositories in Spring Data)
	@Bean
	UserHttpClient userHttpClient() {
	    RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
	    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
	    return factory.createClient(UserHttpClient.class);
	}
}

/*
	This is MVC Application including :
		Model - Data ex. Run, User
		View - Frontend (not for this time ;-;)
		Controller - Get request and delivery response ex. RunController, UserController
*/


/*
- What is application context ?
- annotation (@) ?
- Bean ? https://marupatnote.home.blog/2021/08/03/spring-boot-bean/
- CommandLineRunner ?
*/