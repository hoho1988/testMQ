package com.hoho.testspringboot.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import org.springframework.stereotype.Component;
@Component
public class TestWStaobao {
	public String getResult(String tel) throws Exception{
//		PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        URL realUrl = new URL("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18709224227");
        
        HttpURLConnection connection = null;
        @SuppressWarnings("static-access")
		Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress("111.155.116.240", 8123));
        connection = (HttpURLConnection) realUrl.openConnection(proxy);
        
            // 打开和URL之间的连接
           // URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"gbk"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
                    in.close();
        return result;
		
	}
}
