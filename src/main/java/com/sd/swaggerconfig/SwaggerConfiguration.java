package com.sd.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket postsApi() {
		/*return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/topics/.*")).build();*/
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}
	
	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/api/swagger.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SD APP").description("SD App provides to easy implementaion ")
				.termsOfServiceUrl("http://SwaggerUITest.com").contact("sreesailam.dasari@gmail.com")
				.license("SD App License").termsOfServiceUrl("sreesailam.dasari@gmail.com").licenseUrl("sreesailam@gmail.com").version("2.0").build();
	}
}
