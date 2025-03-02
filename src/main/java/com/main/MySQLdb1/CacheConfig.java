package com.main.MySQLdb1;

import org.ehcache.config.builders.CacheManagerBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;

@Configuration
@EnableCaching
public class CacheConfig {

    // JCache (JSR 107) Cache Manager Configuration (Using Ehcache 3.x)
    @Bean
    public JCacheCacheManager jCacheCacheManager() {
        // Get the JCache CacheManager from Ehcache's JCache provider
        CacheManager jCacheManager = Caching.getCachingProvider().getCacheManager();

        // Return Spring's JCacheCacheManager, wrapping the JCache CacheManager
        return new JCacheCacheManager(jCacheManager);
    }

    // Ehcache 3.x Cache Manager Configuration (For internal Ehcache usage, if needed)
    @Bean
    public org.ehcache.CacheManager ehCacheCacheManager() {
        // Create an Ehcache CacheManager using Ehcache 3.x API
        org.ehcache.CacheManager ehCacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("myCache", // Example cache configuration
                        org.ehcache.config.builders.CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                                org.ehcache.config.builders.ResourcePoolsBuilder.heap(100)))  // configure cache with max 100 entries
                .build();
        
        // Initialize the CacheManager
        ehCacheManager.init();
        
        // Return the Ehcache CacheManager (for internal usage if needed)
        return ehCacheManager;
    }
}
