package com.example.SmartIot.thread;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.SmartIot.constant.AirConditionerConstants;
import com.example.SmartIot.constant.AirConditionerConstants.FanSpeed;
import com.example.SmartIot.constant.AirConditionerConstants.Mode;
import com.example.SmartIot.entity.AirConditioner;
import com.example.SmartIot.entity.Device;
import com.example.SmartIot.repository.AirConditionerRepository;
import com.example.SmartIot.repository.DeviceRepository;
import com.example.SmartIot.vo.AirConditionerVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable{
@Autowired DeviceRepository deviceRepository;
@Autowired AirConditionerRepository airConditionerRepository;

    private ServerSocket server;
	private Socket client;
	private BufferedReader in;
	private int port ;
	private String ip ;
	ObjectMapper mapper = new ObjectMapper();

    public ServerThread() {
    }

    public ServerThread(int port, String ip) {
        this.port = port;
        this.ip = ip;
    }

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
                    System.out.println(LocalDateTime.now());
                    System.out.println(line);
                    // return;
                    if(line.contains("冷氣機")){
                    	AirConditionerVo[] airConditioner = mapper.readValue(line,AirConditionerVo[].class);
                    	for (AirConditionerVo ac : airConditioner) {
                    		System.out.println("------------------");
                    		System.out.println("我在這"+ac.getCurrent_temp());
                    		System.out.println("------------------");
                            Optional<Device> op = deviceRepository.findById(ac.getId());
                            Device device = op.get();
                            Optional<AirConditioner> airConditionerAc = airConditionerRepository.findById(ac.getId());
                            AirConditioner airCondition = airConditionerAc.get();
                            device.setStatus(ac.isStatus());
                            airCondition.setCurrent_temp(ac.getCurrent_temp());
                            airCondition.setTarget_temp(ac.getTarget_temp());
                            airCondition.setMode(Mode.valueOf(ac.getMode()));
                            airCondition.setFanSpeed(FanSpeed.valueOf(ac.getFanSpeed()));
                            // deviceRepository.save(device);
                            // airConditionerRepository.save(airCondition);
                    	}
                    }
                    
                    
                    
                    
                
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
    
}
