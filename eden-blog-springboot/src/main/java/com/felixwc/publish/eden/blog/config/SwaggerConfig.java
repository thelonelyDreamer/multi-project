package com.felixwc.publish.eden.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * in order to learn java!
 * created at 2022/6/19 11:02
 *
 * @author felixwc
 */
@Configuration
public class SwaggerConfig {

    //配置了Swagger的Docket的Bean实例
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.OAS_30);
        docket.apiInfo(apiInfo());
        docket.select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.any())
                .build();
        return docket;
    }

    @Bean
    public ApiInfo apiInfo() {
//        DEFAULT = new ApiInfo("Api Documentation",
//        "Api Documentation", "1.0", "urn:tos", DEFAULT_CONTACT,
//        "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
        Contact contact = new Contact("felixwc", "http://www.baidu.com", "2316700204@qq.com");
        ApiInfo apiInfo = new ApiInfo("博客系统",
                "blog",
                "0.1.0",
                "felixwc",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
        return apiInfo;
    }

}
