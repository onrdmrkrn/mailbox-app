package com.example.mailbox;

import com.example.mailbox.entity.Message;
import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@EnableEurekaClient
@SpringBootApplication
@EnableCaching
@EnableFeignClients
public class MailboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailboxApplication.class, args);
	}
	@Bean
	public Config hazelCastConfig() {
		ManagementCenterConfig config = new ManagementCenterConfig();
		return new Config().setManagementCenterConfig(config);
	}

	@Bean
	public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
		return Hazelcast.newHazelcastInstance(hazelCastConfig);
	}

	@Bean
	public Map<String, Message> messageMap(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance){
		return hazelcastInstance.getMap("messageMap");
	}



}
