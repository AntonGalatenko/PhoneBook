package com.toxa.phonebook2.config;

//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("com.toxa.phonebook2")
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

//    @Bean
//    public ViewResolver contentNegotiatingViewResolver(
//            ContentNegotiationManager manager) {
//
//        List< ViewResolver > resolvers = new ArrayList< ViewResolver >();
//
//        InternalResourceViewResolver r1 = new InternalResourceViewResolver();
//        r1.setPrefix("/WEB-INF/pages/");
//        r1.setSuffix(".jsp");
//        r1.setViewClass(JstlView.class);
//        resolvers.add(r1);
//
//        JsonViewResolver r2 = new JsonViewResolver();
//        resolvers.add(r2);
//
//        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
//        resolver.setViewResolvers(resolvers);
//        resolver.setContentNegotiationManager(manager);
//        return resolver;
//
//    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
        converters.add(stringConverter);

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/view/resources/");
    }

//@Override
//	public void configureContentNegotiation(
//			ContentNegotiationConfigurer configurer) {
//		// Simple strategy: only path extension is taken into account
//		configurer.favorPathExtension(true).
//			ignoreAcceptHeader(true).
//			useJaf(false).
//			defaultContentType(MediaType.TEXT_HTML).
//			mediaType("html", MediaType.TEXT_HTML).
//			mediaType("xml", MediaType.APPLICATION_XML).
//			mediaType("json", MediaType.APPLICATION_JSON);
//	}

//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(mappingJackson2HttpMessageConverter());
//    }

//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setObjectMapper(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
//        return converter;
//    }

}