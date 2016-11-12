
package com.poozer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
@SpringBootApplication
public class WebApplication {

  

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(WebApplication.class);
		application.addListeners(new ApplicationPidFileWriter("/home/poozer/app/poozer.pid"));
		application.run(args);
	}

}
