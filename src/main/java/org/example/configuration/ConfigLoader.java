package org.example.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

     public ApplicationGetPropertys load (String file) throws IOException {

         Properties properties = new Properties();


         try {
             FileInputStream fileInputStream = new FileInputStream(file);
             properties.load(fileInputStream);
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }

         ApplicationGetPropertys applicationGetPropertys = new ApplicationGetPropertys();
         applicationGetPropertys.setBaseURLlogin(properties.getProperty("к"));




         return applicationGetPropertys;
     }

     public String getProfile(){
         String profile = System.getProperty("app.profile");
         if(profile==null){return "dev";}
         return profile;
     }




}
