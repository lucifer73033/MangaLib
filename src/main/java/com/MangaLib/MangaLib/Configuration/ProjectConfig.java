package com.MangaLib.MangaLib.Configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.MangaLib.MangaLib")
@EnableFeignClients(basePackages = "com.MangaLib.MangaLib")
public class ProjectConfig {
}
