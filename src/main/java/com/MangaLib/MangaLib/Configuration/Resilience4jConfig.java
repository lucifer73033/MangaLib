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
    @Bean(value = "def")
    RateLimiterConfigCustomizer rateLimiterConfigCustomizer1(){
        return RateLimiterConfigCustomizer.of("def",builder -> builder
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .limitForPeriod(5)
                .timeoutDuration(Duration.ofSeconds(1))
                .build());
    }
    @Bean(value= "atHome")
    RateLimiterConfigCustomizer rateLimiterConfigCustomizer2(){
        return RateLimiterConfigCustomizer.of("atHome",builder -> builder
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .limitForPeriod(40)
                .timeoutDuration(Duration.ofMillis(100))
                .build());
    }
}
