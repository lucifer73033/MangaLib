package com.MangaLib.MangaLib.Configuration;

import io.github.resilience4j.common.ratelimiter.configuration.RateLimiterConfigCustomizer;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.cloud.util.ConditionalOnBootstrapEnabled;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Map;

@Configuration
public class Resilience4jConfig {
    @Bean(value = "manga")
    RateLimiterConfigCustomizer rateLimiterConfigCustomizer(){
        return RateLimiterConfigCustomizer.of("manga",builder -> builder
                .limitRefreshPeriod(Duration.ofMinutes(10))
                .limitForPeriod(1)
                .timeoutDuration(Duration.ofSeconds(0))
                .build());
    }
    @Bean(value = "")
}
