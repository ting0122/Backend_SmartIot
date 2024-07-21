package com.example.SmartIot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.SmartIot.constant.AirConditionerConstants.FanSpeed;
import com.example.SmartIot.constant.AirConditionerConstants.Mode;
import com.example.SmartIot.entity.Device;
import com.example.SmartIot.repository.AirConditionerRepository;
import com.example.SmartIot.repository.DeviceRepository;
import com.example.SmartIot.vo.AirConditionerVo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Transactional
@Component
public class SocketServer {

	@Autowired
    private AirConditionerRepository airConditionerRepository;

	// 宣告變數
	private ServerSocket serverAC;
	private ServerSocket serverAP;
	private ServerSocket serverDE;
	private Socket clientAC;
	private Socket clientAP;
	private Socket clientDE;
	private BufferedReader inAC;
	private BufferedReader inAP;
	private BufferedReader inDE;
	private String ip = "26.115.194.94";
	private int portAc = 80;
	private int portAp = 81;
	private int portDe = 82;
	ObjectMapper mapper = new ObjectMapper();

	// 調整設定'
	private ArrayList<Map<String, Object>> updateMsg;

	public SocketServer() {
		super();
	}

	@PostConstruct
	public void startACServer() {
		new Thread() {
			@Override
			public void run() {
				try {
					// Step1：建立 server 端的 socket
					InetAddress inetAddress = InetAddress.getByName(ip);
					serverAC = new ServerSocket(portAc, 10000, inetAddress);
					System.out.println("Server started");
				} catch (IOException e) {
					e.printStackTrace();
				}

				while (true) {
					try {
						// Step2：server 啟動監聽
						System.out.println("Waiting for a client ...");
						clientAC = serverAC.accept();
						System.out.println("Client accepted");

						// Step3：讀取 client 的資料
						inAC = new BufferedReader(new InputStreamReader(clientAC.getInputStream()));
						String line = "";
						while ((line = inAC.readLine()) != null) {
							System.out.println(LocalDateTime.now());
							System.out.println(line);
							AirConditionerVo[] airConditioner = mapper.readValue(line,AirConditionerVo[].class);

							// 存入資料庫
							for (AirConditionerVo ac : airConditioner) {
								System.out.println("**************");
								System.out.println(ac.getId());
								System.out.println(ac.isStatus());
								System.out.println(ac.getCurrent_temp());
								System.out.println(ac.getTarget_temp());
								System.out.println(FanSpeed.valueOf(ac.getFanSpeed()));
								System.out.println(Mode.valueOf(ac.getMode()));
								System.out.println("**************");
								airConditionerRepository.updateData(ac.getId(), ac.isStatus(), ac.getCurrent_temp(), ac.getTarget_temp(), ac.getFanSpeed(), ac.getMode());
								System.out.println("成功更新");
							}

						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	@PostConstruct
	public void startAPServer() {
	}

	@PostConstruct
	public void startDEServer() {
	}

}
