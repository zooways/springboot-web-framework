package cn.zooways.app.config;
import cn.zooways.app.service.AdminUserService;
import cn.zooways.app.service.UserService;
import cn.zooways.app.token.TokenHandlerInterceptor;
import cn.zooways.app.token.TokenMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@Order(1)
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private CoreProperties coreProperties;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .exposedHeaders("*")
                .allowCredentials(true).allowedMethods("GET", "POST", "PUT", "DELETE").maxAge(3600);
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(new AppExceptionResolver());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new TokenMethodArgumentResolver());
        resolvers.add(new PageableHandlerMethodArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        TokenHandlerInterceptor interceptor = (TokenHandlerInterceptor) applicationContext.getBean("tokenHandlerInterceptor");
        TokenHandlerInterceptor adminInterceptor = (TokenHandlerInterceptor) applicationContext.getBean("adminTokenHandlerInterceptor");
        coreProperties.getAnonymousPathPatterns().add("/user/login/**");
        coreProperties.getAnonymousPathPatterns().add("/admin/user/login/**");
        registry.addInterceptor(interceptor)
                .excludePathPatterns(coreProperties.getAnonymousPathPatterns());
        registry.addInterceptor(adminInterceptor)
                .excludePathPatterns(coreProperties.getAnonymousPathPatterns());
    }

    @Bean("tokenHandlerInterceptor")
    public TokenHandlerInterceptor tokenHandlerInterceptor(UserService tokenVerifier) {
        TokenHandlerInterceptor interceptor = new TokenHandlerInterceptor(tokenVerifier);
        interceptor.setExcludePrefix("/admin");
        return interceptor;
    }

    @Bean("adminTokenHandlerInterceptor")
    public TokenHandlerInterceptor adminTokenHandlerInterceptor(AdminUserService tokenVerifier) {
        TokenHandlerInterceptor interceptor = new TokenHandlerInterceptor(tokenVerifier);
        interceptor.setTokenHeaderName(Constants.ADMIN_TOKEN_HEADER);
        interceptor.setInterceptByDefault(true);
        interceptor.setCheckRole(true);
        interceptor.setIncludePrefix("/admin");
        return interceptor;
    }
}
