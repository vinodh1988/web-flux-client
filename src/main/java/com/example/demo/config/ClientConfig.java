package com.example.demo.config;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

public class ClientConfig {
  private static WebClient wc;
  static {
	wc=WebClient.builder()
	   .baseUrl("http://localhost:8880")
	   .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
	   .defaultHeader(HttpHeaders.USER_AGENT, "My Web client")
	   .build();
  }
  
  public static WebClient getWc() {
	  return wc;
  }
}
