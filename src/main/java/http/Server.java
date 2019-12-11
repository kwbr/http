package http;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class Server {
	
	public static void main(String[] args) throws IOException {
		
		var server = HttpServer.create(new InetSocketAddress(8080), 0);
		
		server.createContext("/hello", he -> {
			var body = "hello";
			he.sendResponseHeaders(200, body.getBytes().length);
			
			try (var os = he.getResponseBody()) {
				os.write(body.getBytes());
			}
		});
		server.start();

		System.out.println("Started");
	}

}
