package com.example.SmartIot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Component;

import com.example.SmartIot.thread.ServerThread;
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
	private String ip = "26.115.194.94";
	private int portAc = 80;
	private int portAp = 81;
	private int portDe = 82;
	ObjectMapper mapper = new ObjectMapper();

	public SocketServer() {
		super();
	}

	@PostConstruct
	public void startServer() {
		ServerThread acThread = new ServerThread(portAc,ip);
		Thread ac = new Thread(acThread);
		ServerThread apThread = new ServerThread(portAp,ip);
		Thread ap = new Thread(apThread);
		ServerThread deThread = new ServerThread(portDe,ip);
		Thread de = new Thread(deThread);
		ac.start();
		ap.start();
		de.start();


}}
