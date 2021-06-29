package com.example.demo.messaging;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.example.demo.entity.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonDeserializer implements Deserializer<Person> {

	@Override
	public Person deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		ObjectMapper obj=new ObjectMapper();
		Person p;
		try {
			p = obj.readValue(data, Person.class);
			return p;
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}

}
