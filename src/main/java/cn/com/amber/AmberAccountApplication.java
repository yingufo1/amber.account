package cn.com.amber;import org.springframework.boot.SpringApplication;import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.cloud.client.discovery.EnableDiscoveryClient;/** * 启动类 * * @author yangying * @version 1.0 * @since 2022/9/3 **/@SpringBootApplication@EnableDiscoveryClientpublic class AmberAccountApplication {    public static void main(String[] args) {        SpringApplication.run(AmberAccountApplication.class);    }}