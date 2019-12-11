package http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Client {

	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		URI uri = URI.create("http://localhost:8080/hello"); 
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	
		System.out.println(response.request().toString());
		
		System.out.println(response.statusCode());
		System.out.println(response.headers());
	}
	
}
