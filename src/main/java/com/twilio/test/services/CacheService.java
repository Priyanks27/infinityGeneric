package com.twilio.test.services;

public interface CacheService {

    Object getCache(String key);

    Boolean putCache(String key, Object object);

    Boolean removeCacheByKey(String key);

    Boolean removeAllKeys();
}
