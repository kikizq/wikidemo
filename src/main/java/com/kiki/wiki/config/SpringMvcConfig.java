package com.kiki.wiki.config;

import com.kiki.wiki.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author qizhang
 * @date 2021/10/21
 * @desc
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
//    @Resource
//    LoginInterceptor loginInterceptor;
//
//    @Resource
//    ActionInterceptor actionInterceptor;
//
    @Resource
    LogInterceptor logInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns(
//                        "/test/**",
//                        "/redis/**",
//                        "/user/login",
//                        "/category/all",
//                        "/ebook/list",
//                        "/doc/all/**",
//                        "/doc/vote/**",
//                        "/doc/find-content/**",
//                        "/ebook-snapshot/**"
//                );
//
//        registry.addInterceptor(actionInterceptor)
//                .addPathPatterns(
//                        "/*/save",
//                        "/*/delete/**",
//                        "/*/reset-password");
        registry.addInterceptor(logInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login");
    }
}
