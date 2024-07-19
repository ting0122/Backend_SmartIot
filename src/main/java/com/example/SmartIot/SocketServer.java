package com.example.SmartIot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Component;

import com.example.SmartIot.vo.AirConditionerVo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Component
public class SocketServer {

	// 宣告變數
	private ServerSocket server;
	private Socket client;
	private BufferedReader in;
	private int port = 80;
	private String ip = "26.115.194.94";
	ObjectMapper mapper = new ObjectMapper();

	public SocketServer() {
		super();
	}

	@PostConstruct
	public void startServer() {
		new Thread() {
			@Override
			public void run() {
				try {
					// Step1：建立 server 端的 socket
					InetAddress inetAddress = InetAddress.getByName(ip);
					server = new ServerSocket(port, 10000, inetAddress);
					System.out.println("Server started");
				} catch (IOException e) {
					e.printStackTrace();
				}

				while (true) {
					try {
						// Step2：server 啟動監聽
						System.out.println("Waiting for a client ...");
						client = server.accept();
						System.out.println("Client accepted");

						// Step3：讀取 client 的資料
						in = new BufferedReader(new InputStreamReader(client.getInputStream()));
						String line = "";
						while ((line = in.readLine()) != null) {
							System.out.println(line);
							

							// List<AirConditionerVo> airConditioner = mapper.readValue(line, new TypeReference<List<AirConditionerVo>>(){});
							
							// for (AirConditionerVo ac : airConditioner) {
							// 	System.out.println(ac);
							// }
							
						
						}

						// Step4：關閉 socket
						client.close();
						in.close();
						System.out.println("Closing connection");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
}}
