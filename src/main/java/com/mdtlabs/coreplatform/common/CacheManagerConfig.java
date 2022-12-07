package com.mdtlabs.coreplatform.common;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class CacheManagerConfig extends CachingConfigurerSupport {

	@Bean
	public net.sf.ehcache.CacheManager ehCacheManager() {
		CacheConfiguration tokensCache = new CacheConfiguration();
		tokensCache.setName("tokens");
		tokensCache.setMemoryStoreEvictionPolicy("LFU");
		tokensCache.setMaxEntriesLocalHeap(100);
//		tokensCache.setTimeToLiveSeconds(120);

		CacheConfiguration apiRolePermissionCache = new CacheConfiguration();
		apiRolePermissionCache.setName("apiRolePermissions");
		apiRolePermissionCache.setMemoryStoreEvictionPolicy("LFU");
		apiRolePermissionCache.setMaxEntriesLocalHeap(100);

		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		config.addCache(tokensCache);
		config.addCache(apiRolePermissionCache);
		return net.sf.ehcache.CacheManager.newInstance(config);
	}

	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
//		return super.cacheManager();
	}

}
