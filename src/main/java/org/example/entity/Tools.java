package org.example.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.example.configuration.ConfigLoader;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Data
public class Tools {

    Map<String, Object>  tools = new HashMap<>();


    HttpClient httpClient;
    ObjectMapper objectMapper;
    ConfigLoader configLoader;


    public void packing(){
        tools.put("HttpClient",httpClient);
        tools.put("ObjectMapper",objectMapper);
        tools.put("ConfigLoader",configLoader);
    }

    public Map<String, Object> getTools(){
        return tools;
    }


}





