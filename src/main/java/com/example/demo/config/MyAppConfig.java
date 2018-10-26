package com.example.demo.config;

import com.example.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration:指明当前类是一个配置类，用来代替之前的.xml配置文件
 * Created by Administrator on 2018/10/17.
 */

@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中，这个组件的id就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("给容器中添加组件");
        return new HelloService();
    }

}
