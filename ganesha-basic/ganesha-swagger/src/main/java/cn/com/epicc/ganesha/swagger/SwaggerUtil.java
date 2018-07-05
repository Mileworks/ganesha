package cn.com.epicc.ganesha.swagger;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description: Swagger文档工具类,只在测试环境和可开发环境开启
 * Author: lishangmin
 * Created: 2018-05-21 15:53
 */
@Configuration
@EnableSwagger2
//@Profile({"dev","test"})
public class SwaggerUtil extends WebMvcConfigurerAdapter {

    @Value("${swagger.show:false}")
    private boolean swaggerShow;

    private static ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("中国人保API文档")
                .contact(new Contact("Arrows","http://www.epicc.com.cn/","shangmlee@foxmail.com"))
                .build();
    }

    @Bean
    public Docket initDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.com.epicc.ganesha"))
                .paths(PathSelectors.any())
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if(swaggerShow) {
            registry.addResourceHandler("/swagger-ui.html").addResourceLocations(
                    "classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
    }

}
