package GreetingGeneratorService.Controller;

import GreetingGeneratorService.Client.ApiService;
import com.mashape.unirest.http.exceptions.UnirestException;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by annakertesz on 12/18/16.
 */
public class ApiController {

        private final ApiService apiService;

        public ApiController(ApiService apiService) {
            this.apiService = apiService;
        }

        public String random(Request req, Response res) throws IOException, URISyntaxException, UnirestException {
            return apiService.random();
        }


}
