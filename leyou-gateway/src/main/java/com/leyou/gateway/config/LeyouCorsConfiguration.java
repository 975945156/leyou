package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: xuzhiqiang
 * @Date: 2020/11/18 16:57
 */
@Configuration
public class LeyouCorsConfiguration {

    @Bean
    public CorsFilter corsFilter(){

        //初始化cors配置对象
        CorsConfiguration configuration = new CorsConfiguration();

        //1.添加CORS配置信息
        //1) 允许的域,不要写*，否则cookie就无法使用了
        configuration.addAllowedOrigin("http://manage.leyou.com");
        //2) 是否发送Cookie信息
        configuration.setAllowCredentials(true);//允许携带cookie
        //3) 允许的请求方式
        configuration.addAllowedMethod("*");
//        configuration.addAllowedMethod("OPTIONS");
//        configuration.addAllowedMethod("HEAD");
//        configuration.addAllowedMethod("GET");
//        configuration.addAllowedMethod("PUT");
//        configuration.addAllowedMethod("POST");
//        configuration.addAllowedMethod("DELETE");
//        configuration.addAllowedMethod("PATCH");
        // 4）允许的头信息
        configuration.addAllowedHeader("*");


        //初始化cors配置源对象
        UrlBasedCorsConfigurationSource configurationSource=new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",configuration);

        //返回corsFilter实例,参数:cors配置源对象
        return new CorsFilter(configurationSource);

    }
}
