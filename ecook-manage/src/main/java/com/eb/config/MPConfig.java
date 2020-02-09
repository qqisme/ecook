package com.eb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 *	打开MP分页拦截器 
 *
 */
@Configuration
public class MPConfig {

	@Bean
	public PaginationInterceptor pageConfig() {
		return new PaginationInterceptor();
	}
	
}
