package com.juhe.sevice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.juhe.entity.Dream;
import com.juhe.entity.News;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class DreamApiService {
     public  static List<Dream> getDream(String dtype) {
         List<Dream> dreamList = new ArrayList<>();
         HttpClient client = new HttpClient();
         GetMethod method = new GetMethod("http://v.juhe.cn/dream/category?key=1eafa5dc1c6c1669a3b981e8b88945f1");
         int code;
         String data = "";
         try {
             //执行请求
             code = client.executeMethod(method);
             //如果成功
             if (code == HttpURLConnection.HTTP_OK) {
                 data = method.getResponseBodyAsString();
                 JSONObject jsonObject = JSONObject.parseObject(data);
                 Object o = jsonObject.get("result");
                 JSONArray jsonArray = JSONArray.parseArray(o.toString());
                 dreamList = JSONArray.parseArray(jsonArray.toJSONString(),Dream.class);
//                 dreamList.forEach(dream -> System.out.println(dream));
//                 System.out.println(dreamList.size());
             }
         } catch (HttpException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         method.releaseConnection();//释放连接
         return dreamList;
     }

    public static void main(String[] args) {
        getDream("json");
    }
}

