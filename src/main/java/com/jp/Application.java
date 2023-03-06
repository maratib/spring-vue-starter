package com.jp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application {

	@Value("${server.port}")
	private int serverPort;

	@Value("${app.version}")
	public String version;

	public static String appVersion;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct()
	public void onStart() throws Exception {
		Application.appVersion = version;
		System.out.println("IDC-Adapter started at port : " + serverPort);
		log.warn("IDC-Adapter started at port : " + serverPort);
	}

	@PreDestroy
	public void onExit() {
		log.warn("IDC-Adapter stopped.");
	}

}
