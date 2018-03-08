package io.github.rynffoll.ignite.autoconfigure;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConditionalOnClass(Ignite.class)
@ConditionalOnProperty(name = "spring.ignite.enabled", matchIfMissing = true)
@EnableConfigurationProperties(IgniteProperties.class)
public class IgniteAutoConfiguration {

    @Autowired
    private IgniteProperties igniteProperties;

    @Bean
    public Ignite ignite() {
        Ignite ignite = Ignition.start(igniteProperties);
        ignite.active(true); // TODO: consider about moving to properties
        return ignite;
    }
}
