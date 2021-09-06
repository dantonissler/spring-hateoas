package com.howtodoinjava.rest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.http.MediaType;
import org.springframework.plugin.core.OrderAwarePluginRegistry;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.filter.ForwardedHeaderFilter;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = HypermediaAutoConfiguration.class)
public class SpringBootHateoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHateoasApplication.class, args);
    }

//    @Bean
//    @Primary
//    public LinkDiscoverers discoverers() {
//        List<LinkDiscoverer> plugins = new ArrayList<>();
//        plugins.add(new CollectionJsonLinkDiscoverer());
//        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
//    }
    @Bean
    public PluginRegistry<LinkDiscoverer, MediaType> discoverers(
            OrderAwarePluginRegistry<LinkDiscoverer, MediaType> relProviderPluginRegistry) {
        return relProviderPluginRegistry;
    }

    @Bean
    public FilterRegistrationBean<ForwardedHeaderFilter> forwardedHeaderFilter() {
        FilterRegistrationBean<ForwardedHeaderFilter> result = new FilterRegistrationBean<>();
        result.setFilter(new ForwardedHeaderFilter());
        result.setOrder(0);
        return result;
    }

//	@Bean
//	ForwardedHeaderFilter forwardedHeaderFilter() {
//	    return new ForwardedHeaderFilter();
//	}
}
