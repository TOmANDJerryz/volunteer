package com.volunteer;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.volunteer.config.JwtFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@MapperScan("com.volunteer.sys.dao")
@Controller
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.volunteer.*.mapper")
public class VolunteerHelpApplication {

//	@Bean
//	public FilterRegistrationBean jwtFilter() {
//		FilterRegistrationBean rbean = new FilterRegistrationBean();
//		rbean.setFilter(new JwtFilter());
////		rbean.addUrlPatterns("/user/*");// 过滤user下的链接
////		rbean.addUrlPatterns("/files/*");
////		rbean.addUrlPatterns("/import/*");
////		rbean.addUrlPatterns("/role/*");
////		rbean.addUrlPatterns("/rolemenu/*");
////		rbean.addUrlPatterns("/foreignHouse/*");
////		rbean.addUrlPatterns("/villa/*");
////		rbean.addUrlPatterns("/high/*");
////		rbean.addUrlPatterns("/classify/*");
//
//		return rbean;
//	}

	/**
	 * 分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(VolunteerHelpApplication.class, args);
	}

}
