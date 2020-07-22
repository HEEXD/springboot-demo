package com.hxd.springbootdemo.commons.entity;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * MyBatis 返回 Map，查询字段两列分别作为 key 和 value
 *
 * Created by hee on 2020/6/16 10:40
 */
public class MapResultHandler implements ResultHandler {

    private final Map<String,String> mappedResults = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public void handleResult(ResultContext resultContext) {
        Map<String,String> map = (Map<String,String>) resultContext.getResultObject();
        // xml配置里面的property的值，对应的列
        mappedResults.put(map.get("key"), map.get("value"));
    }

    public Map<String,String> getMappedResults() {
        return mappedResults;
    }
}
