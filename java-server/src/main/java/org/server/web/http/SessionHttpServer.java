package org.server.web.http;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
public class SessionHttpServer {

    private static Map<String, String> sessions = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Context for handling requests
        server.createContext("/", new MyHandler());

        // Set the executor (null means the default executor)
        server.setExecutor(null);

        // Start the server
        server.start();

        System.out.println("Server is listening on port " + port);
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Get the session ID from the cookie or create a new one
            String sessionId = getSessionId(exchange);

            // Handle the request based on the session
            handleRequest(exchange, sessionId);
        }

        private String getSessionId(HttpExchange exchange) {
            // Extract the session ID from the "Session-Id" cookie
            String sessionId = null;
            for (String cookie : exchange.getRequestHeaders().getOrDefault("Cookie", new ArrayList<>())) {
                if (cookie.startsWith("Session-Id=")) {
                    sessionId = cookie.substring("Session-Id=".length());
                    break;
                }
            }

            // If no session ID is found, create a new one
            if (sessionId == null || !sessions.containsKey(sessionId)) {
                sessionId = UUID.randomUUID().toString();
                sessions.put(sessionId, "Sample Session Data");
            }

            // Set the "Session-Id" cookie in the response
            exchange.getResponseHeaders().add("Set-Cookie", "Session-Id=" + sessionId);

            return sessionId;
        }

        private void handleRequest(HttpExchange exchange, String sessionId) throws IOException {
            // Your logic to handle the request based on the session ID
            // For example, you can access session data using sessions.get(sessionId)

            String response = "Hello, Session ID: " + sessionId;

            // Send the response
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}