package com.example.SmartIot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SmartIot.constant.AirConditionerConstants;
import com.example.SmartIot.constant.AirConditionerConstants.Mode;

@SpringBootTest
class SmartIotApplicationTests {


	@Test
	void contextLoads() {
		
		Mode a = Mode.valueOf("COOL");
		System.out.println(a);
	}

}
