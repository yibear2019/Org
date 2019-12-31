package com.bearbaba.orgconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-dubbo.xml")
public class OrgConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrgConsumerApplication.class, args);
		System.out.println("消费端启动成功!");
	}

}
