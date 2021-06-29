package com.example.demo.messaging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.kafka.receiver.ReceiverOffset;

@Component
public class MessageReceiver implements InitializingBean {
  @Autowired
      ConsumerConfiguration configuration;
  
  
  
  public void consumeMessages() {
	  configuration.getFlux().subscribe(record ->{
		  ReceiverOffset offset = record.receiverOffset();
		  String data ="\n "+ record.key() +"  "+record.value().getName()+" received from "+record.topic();
		   System.out.println(record.value());
		  try {
			Files.write(Paths.get("e:/result.txt"), data.getBytes(), StandardOpenOption.APPEND);
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	  });
  }

@Override
public void afterPropertiesSet() throws Exception {
	// TODO Auto-generated method stub
	 consumeMessages();
  }
}
