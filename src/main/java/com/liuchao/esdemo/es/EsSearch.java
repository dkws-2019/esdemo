package com.liuchao.esdemo.es;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import com.google.gson.JsonObject;
import com.liuchao.esdemo.entity.Page;
import com.liuchao.esdemo.entity.User;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EsSearch {
    //索引值 index
    private static final String INDEX="logdemo";
    //这个是文档 type
    private static final String TYPE="user";
    @Autowired
    private JestClient jestClient;

    public JSONObject  allFind(String key,int pageSize,int pageNum){

        //全文搜索并加分页排序
        String json="{\"query\": {\"multi_match\": {\"query\": \""+key+"\",\"fields\": [\"user_name\",\"salt\",\"open_id\"]}},\"size\":\""+pageSize+"\",\"from\":\""+(pageNum-1)*pageSize+"\",\"sort\":[{\"create_time\":{\"order\":\"desc\"}}]}\n";
        Search search = new Search.Builder(json).addIndex(INDEX).addType(TYPE).build();
        JSONObject returnObject=null;
        try{
            //查询es执行查询语句
            SearchResult result = jestClient.execute(search);
            //得到返回结果
            JsonObject jsonObject = result.getJsonObject();
            returnObject = toObject(jsonObject, pageSize, pageNum);
            return  returnObject;
        }catch (Exception e){
            e.printStackTrace();
        }
            return returnObject;
    }

    //解析返回结果 拼凑返回结果带分页信息
    public  JSONObject toObject(JsonObject jsonObject,int pageSize,int pageNum){
        JSONObject returnObject=new JSONObject();
        List<JSONObject> list=new ArrayList<>();
        JsonObject hits = jsonObject.getAsJsonObject("hits");
        JsonObject total = hits.getAsJsonObject("total");
        JsonElement value = total.get("value");
        int totleCount = value.getAsInt();
        Page page=new Page(pageSize,pageNum,totleCount);
        returnObject.put("page",page);
        returnObject.put("datas",list);
        JsonArray hits1 = hits.getAsJsonArray("hits");
        if(StringUtils.isEmpty(hits1)){
            return returnObject;
        }
        Iterator<JsonElement> iterator = hits1.iterator();
        while (iterator.hasNext()){
            JsonElement next = iterator.next();
            JsonObject asJsonObject = next.getAsJsonObject();
            JsonElement source = asJsonObject.get("_source");
            String s = source.toString();
            //User user = JSONObject.parseObject(s, User.class);
            //list.add(user);
            JSONObject user = JSONObject.parseObject(s);
            list.add(user);
        }
        return returnObject;

    }

}
