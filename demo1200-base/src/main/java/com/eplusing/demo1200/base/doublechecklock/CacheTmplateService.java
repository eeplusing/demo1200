package com.eplusing.demo1200.base.doublechecklock;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
public class CacheTmplateService {
    private Map client;
    public <T> T findCache(String key, Date expire, TypeReference<T> clazz, LoadCallback<T> load){
        String json = client.get(key) + "";
        if (StringUtils.isBlank(json) || json.equalsIgnoreCase("null")) {
            //所有的线程只要等待在这里的都将去数据库查
            synchronized (this) {
                json = client.get(key) + "";
                if (StringUtils.isBlank(json) || json.equalsIgnoreCase("null")) {
                //模拟缓存没找到去数据库查找花费的时间
                    T t = load.load();

                    //client.set(key, json, expire);

                    return t;
                }
                return JSON.parseObject(json, clazz);
            }
        }else{
            return JSON.parseObject(json, clazz);
        }
    }
}