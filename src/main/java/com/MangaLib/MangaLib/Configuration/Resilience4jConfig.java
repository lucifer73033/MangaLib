package com.MangaLib.MangaLib.Configuration;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.configure.RateLimiterConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4jConfig {
    @Bean
    RateLimiter rateLimiter(){
        return RateLimiter.of("AtHome",RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .limitForPeriod(40)
                .timeoutDuration(Duration.ofMinutes(1))
                .build()
        );
    }
}
