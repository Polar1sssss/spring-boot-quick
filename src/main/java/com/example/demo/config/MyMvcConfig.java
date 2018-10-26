package com.example.demo.config;

import com.example.demo.component.LoginHandlerInterceptor;
import com.example.demo.component.MyLocaleResovler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * �ȱ��������е��Զ����ã�Ҳ��ʹ����չ����
 * @EnableWebMvc��ȫ��ӹ�SpringMVC������SpringMVC���Զ�����ȫ��ʧЧ
 * @author hujtb
 * @create on 2018-10-22-12:37
 */

//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //��������͡�atguigu����������successҳ��
        registry.addViewController("/atguigu").setViewName("success");
    }

    //���е�WebMvcConfigurer�������������
    @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        WebMvcConfigurer webMvcConfigurer =  new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //ע��������
            //��������������Ҫ�ų�ĳЩ����
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/main.html");
            }
        };
        return webMvcConfigurer;
    }

    //ע�ᵽ�����У�����SpringBoot�Դ���LocaleResovler
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResovler();
    }
}
