/**
 * Copyright 2014 China Mobile. All Right Reserved
 * 
 * This file is owned by China Mobile and you may not use, modify, copy, 
 * redistribute this file without written permissions.
 * 
 * These Terms of Use define legal use of this file, all updates, revisions, 
 * substitutions for you. All rights not expressly granted to you are reserved 
 * by Chinamobile. 
 */

package com.test.java.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <code>{@link JsonUtils}</code>
 * 
 * TODO : document me
 * 
 * @author Wang, Zhihao
 */
public class JsonUtils {
    
    private final static ObjectMapper mapper = new ObjectMapper();
    private final static Logger log = LoggerFactory.getLogger(JsonUtils.class);
    static {
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    }
    
    public static <T> T readValue(String value,Class<T> type) throws Exception{
        return mapper.readValue(value, type);
    }
    
    public static String toString(Object object) {

        String result = null;
        if (null == object)
            return result;
        try {
            result = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("对象转换成json字符串出错",e);
        }
        return result;
    }

}
