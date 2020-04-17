package com.cacheDemo.config;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableCaching
public class APIConfig extends CachingConfigurerSupport {

	@Bean
	public net.sf.ehcache.CacheManager ehCacheManger(){
		CacheConfiguration configuration = new CacheConfiguration();
		configuration.setName("ten-second-cache");
		configuration.setMaxEntriesLocalHeap(1000);
		configuration.timeToLiveSeconds(10);
		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		config.addCache(configuration);
		return net.sf.ehcache.CacheManager.newInstance(config);
	}
	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManger());
	}
}
