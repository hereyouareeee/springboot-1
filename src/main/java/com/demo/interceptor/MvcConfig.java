package com.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by huguoju on 2016/12/30.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.demo.controller")
@PropertySource(value = "classpath:application.properties",
        ignoreResourceNotFound = true,encoding = "UTF-8")
public class MvcConfig extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(MvcConfig.class);
    @Autowired
    LoginInterceptor loginInterceptor;

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//    @Bean
//    public MessageSource messageSource(){
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.addBasenames("classpath:messages/messages");
//        messageSource.setCacheSeconds(60);
//        messageSource.setUseCodeAsDefaultMessage(false);
//        return messageSource;
//    }
//    @Bean
//    public RequestMappingHandlerMapping handlerMapping() {
//        return new RequestMappingHandlerMapping();
//    }
//
//    @Bean(name = "validator")
//    public LocalValidatorFactoryBean validator() {
//        LocalValidatorFactoryBean factoryBean =  new LocalValidatorFactoryBean();
//        factoryBean.setProviderClass(HibernateValidator.class);
//        factoryBean.setValidationMessageSource(messageSource());
//        return factoryBean;
//    }

//    @Override
//    public Validator getValidator() {
//        return validator();
//    }
    /**
     * 注册方法级别验证
     * <p>
     *     使用必须加在类中加@{@code @Validated}注解
     *     在Controller 方法中加@NotEmpty 验证
     * </p>
     * @return
     */
//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor() {
//        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
//        processor.setValidatorFactory(validator());
//        return processor;
//    }

    /**

     * <p>
     *     视图处理器
     * </p>
     *
     * @return
     */
//    @Bean
//    public ViewResolver viewResolver() {
//        logger.info("ViewResolver");
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/jsp/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册监控拦截器
//        registry.addInterceptor(securityInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/configuration/ui");
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
         .excludePathPatterns("/configuration/ui");

    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        builder.featuresToEnable(WRITE_NUMBERS_AS_STRINGS,
//                WRITE_ENUMS_USING_TO_STRING);
//        builder.featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        ObjectMapper mapper = builder.build();
//        mapper.getSerializerProvider().setNullValueSerializer(new
//                CustomJsonSerialize
//                        .NullSerialize());
//        mapper.setDateFormat(new SimpleDateFormat(DateUtils.FULL_DATETIME_WITH_UNDERSCORS));
//        //开启驼峰转下划线
//        //mapper.setPropertyNamingStrategy(PropertyNamingStrategy
//        //        .CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
//        builder.simpleDateFormat(DateUtils.FULL_DATETIME_WITH_UNDERSCORS);
//        converters.add(new MappingJackson2HttpMessageConverter(mapper));
//        //converters.add(new MappingJackson2XmlHttpMessageConverter(builder.xml().build()));
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*/*")
                .allowedMethods("*")
                .maxAge(120);
    }

//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

    /**
     * 资源处理器
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("addResourceHandlers");
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 文件上传处理器
     * @return
     */
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver commonsMultipartResolver() {
//        logger.info("CommonsMultipartResolver");
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//        resolver.setMaxUploadSize(MAX_FILE_UPLOAD_SIZE);
//        return resolver;
//    }
}
