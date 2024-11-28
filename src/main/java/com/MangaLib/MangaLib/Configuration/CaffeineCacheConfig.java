package com.MangaLib.MangaLib.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
@EnableCaching
@Configuration
public class CaffeineCacheConfig {
    @Bean
    public CacheManager cacheManager(){
        CaffeineCacheManager cacheManager=new CaffeineCacheManager();
        cacheManager.registerCustomCache("searchResultDTO", Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterAccess(10,TimeUnit.MINUTES)
                .build());
        cacheManager.registerCustomCache("mangaDTO", Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterAccess(10,TimeUnit.MINUTES)
                .build());
        cacheManager.registerCustomCache("chaptersListDTO", Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterAccess(10,TimeUnit.MINUTES)
                .build());
        cacheManager.registerCustomCache("chapterDTO", Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterAccess(10,TimeUnit.MINUTES)
                .build());
        return cacheManager;

    }
}
