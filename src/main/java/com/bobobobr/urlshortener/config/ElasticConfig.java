package com.bobobobr.urlshortener.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetSocketAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.bobobobr.urlshortener")
@ComponentScan(basePackages = {"com.bobobobr.urlshortener"})
public class ElasticConfig extends ElasticsearchConfiguration {

    @Value(value = "${spring.cache.host}")
    private String host;
    @Value(value = "${spring.cache.port}")
    private int port;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder() //
                .connectedTo(InetSocketAddress.createUnresolved(host, port)) //
                .build();
    }
}
