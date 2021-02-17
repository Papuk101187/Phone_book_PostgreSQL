package org.example.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.configuration.ConfigLoader;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.net.http.HttpClient;
import java.util.Properties;

@AllArgsConstructor
public class BulderTools {

    public static BulderTools bulderTools;
    Tools tools;

    public BulderTools addToolsforHttpClient(HttpClient httpClient){
        tools.setHttpClient(httpClient);
        return this;
    }
    public BulderTools addToolsforObjectMapper(ObjectMapper objectMapper){
        tools.setObjectMapper(objectMapper);
        return this;
    }
    public BulderTools addToolsforConfig(ConfigLoader configLoader){
        tools.setConfigLoader(configLoader);
        return this;
    }

    public Tools build(){
        return tools;
    }

    public static BulderTools bulderTools(){
        return new BulderTools(new Tools());
    }


}
