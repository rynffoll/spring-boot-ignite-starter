package io.github.rynffoll.ignite.autoconfigure;

import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.ignite")
public class IgniteProperties extends IgniteConfiguration {



}
