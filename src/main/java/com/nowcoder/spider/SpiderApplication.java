package com.nowcoder.spider;

import com.nowcoder.spider.service.SpiderService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.nowcoder.spider.dao")
public class SpiderApplication implements CommandLineRunner {

  @Autowired
  private SpiderService spiderService;

	public static void main(String[] args) {
		SpringApplication.run(SpiderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
    spiderService.getLotsOfBooks("https://www.douban.com/doulist/110879547/?start=0&sort=seq&playable=0&sub_type=");
	}
}
