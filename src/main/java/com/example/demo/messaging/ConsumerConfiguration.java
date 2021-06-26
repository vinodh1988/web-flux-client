package com.example.demo.messaging;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.ReceiverRecord;

@Component
public class ConsumerConfiguration {

    private  ReceiverOptions<Integer, String> receiverOptions;
    Flux<ReceiverRecord<Integer, String>> kafkaFlux;
	
    {
	

		        Map<String, Object> props = new HashMap<>();
		        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "sample-consumer");
		        props.put(ConsumerConfig.GROUP_ID_CONFIG, "mygroup");
		        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
		        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		        receiverOptions = ReceiverOptions.create(props);
		        receiverOptions = receiverOptions.subscription(Collections.singleton("junction"))
		                .addAssignListener(partitions -> System.out.printf("onPartitionsAssigned {}", partitions))
		                .addRevokeListener(partitions -> System.out.printf("onPartitionsRevoked {}", partitions));
		        
		        kafkaFlux= KafkaReceiver.create(receiverOptions).receive();
		    
		    
	}
    
    public ReceiverOptions<Integer,String> getReceiver() {
    	return  receiverOptions;
    }
    
    public Flux<ReceiverRecord<Integer, String>> getFlux(){
    	return kafkaFlux;
    }
}
