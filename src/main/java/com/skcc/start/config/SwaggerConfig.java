package com.skcc.start.config;

import com.google.common.base.Predicates;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.egstep"))
//                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
//                .paths(PathSelectors.regex("(?!/error).+"))
//                .paths(PathSelectors.regex("(?!/system).+"))
                .build()
                .apiInfo(apiInfo())
                .pathMapping("/")
//                .pathProvider(new BasePathAwareRelativePathProvider("/"))
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("zFWK")
                .description("spring boot template")
                .version("1.0.0")
                .build();
    }

    class BasePathAwareRelativePathProvider extends AbstractPathProvider {
        private String basePath;

        public BasePathAwareRelativePathProvider(String basePath) {
            this.basePath = basePath;
        }

        @Override
        protected String applicationPath() {
            return basePath;
        }

        @Override
        protected String getDocumentationPath() {
            return "/";
        }

        @Override
        public String getOperationPath(String operationPath) {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");
            return Paths.removeAdjacentForwardSlashes(
                    uriComponentsBuilder.path(operationPath.replaceFirst(basePath, "")).build().toString());
        }
    }

}

