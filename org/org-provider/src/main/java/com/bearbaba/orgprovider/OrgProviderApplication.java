package com.bearbaba.orgprovider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

// 开启基于注解的dubbo功能（主要是包扫描@DubboComponentScan）
// 也可以在配置文件中使用dubbo.scan.base-package来替代   @EnableDubbo
//@EnableDubbo
@ImportResource("classpath:spring-dubbo.xml")
@MapperScan("com/bearbaba/orgprovider/mapper")
@SpringBootApplication
public class OrgProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrgProviderApplication.class, args);
		System.out.println("服务端启动成功!");

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
