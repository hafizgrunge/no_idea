package yose;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.*;

import com.google.gson.Gson;

public class YoseGame {
    public static void main(String[] args) {
    	port(getHerokuAssignedPort());
    	
    	Gson gson = new Gson();
    	
    	get("/", (request, response) -> {
    		response.type("text/html");
    		
            return new ModelAndView(new Object(), "index.ftl");
        }, new FreeMarkerEngine());
    	
    	get("/readme", (request, response) -> {
    		response.type("text/html");
    		
            return new ModelAndView(new Object(), "readme.ftl");
        }, new FreeMarkerEngine());
    	
    	get("/ping", (request, response) -> {
    		response.type("application/json");
    		
    		return new Status(true); 
    	}, gson::toJson);
    	
    	get("/contactme", (request, response) -> {
    		response.type("text/html");
    		
            return new ModelAndView(new Object(), "contactme.ftl");
        }, new FreeMarkerEngine());
    	
    	get("/astroport", (request, response) -> {
    		response.type("text/html");
    		
            return new ModelAndView(new Object(), "astroport.ftl");
        }, new FreeMarkerEngine());

     	get("/primeFactors?:number", (request, response) -> {
    		response.type("application/json");
    		
		return new PrimeFactor(Integer.parseInt(request.params(":number"))); 
    	}, gson::toJson);
    }


    
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
