package org.server.web.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;

public class WebServer {
	
	
	private static  HttpServer httpServer;
	private static  Map<String, List<String>> session = new ConcurrentHashMap<>();
	private static int noOfThreads=3;
	private static ExecutorService httpThreadPool;
	public void startServer() throws IOException {
		httpServer = HttpServer.create(ServerConfiguration.getInstance().getServerAddress(), 0);
		httpServer.createContext("/greet").setHandler(exchange -> {
			String responseMsg = ServerConfiguration.getInstance().getGreetMessage();
			exchange.sendResponseHeaders(200, responseMsg.length());
			OutputStream responseBody = exchange.getResponseBody();
			responseBody.write(responseMsg.getBytes());
			responseBody.flush();
			responseBody.close();

		});
		httpThreadPool = Executors.newFixedThreadPool(this.noOfThreads);
		System.out.println(String.format("Starting server on address %s:%d",
				ServerConfiguration.getInstance().getServerAddress().getHostName(),
				ServerConfiguration.getInstance().getServerAddress().getPort()));
		httpServer.setExecutor(Executors.newCachedThreadPool());
		httpServer.start();
		Runtime.getRuntime().addShutdownHook(new Thread(this.stopServer()));
	}
	public Runnable  stopServer() throws IOException {
		return ()->{
		httpServer.stop(1);
        httpThreadPool.shutdownNow();
        System.out.println("Stopped....");
		};
	}
}
