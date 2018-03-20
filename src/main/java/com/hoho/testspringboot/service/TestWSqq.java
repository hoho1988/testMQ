package com.hoho.testspringboot.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Component;

@Component
public class TestWSqq {
	public String getResult(String xml) throws Exception{
		PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        URL realUrl = new URL("http://www.webxml.com.cn/webservices/qqOnlineWebService.asmx");
        
        HttpURLConnection conn = null;
        @SuppressWarnings("static-access")
		Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress("111.155.116.240", 8123));
        conn = (HttpURLConnection) realUrl.openConnection(proxy);
        
        // 打开和URL之间的连接
        //URLConnection conn = realUrl.openConnection();
        // 设置通用的请求属性
        conn.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
        // 发送POST请求必须设置如下两行
        conn.setDoOutput(true);
        conn.setDoInput(true);
        // 获取URLConnection对象对应的输出流
        out = new PrintWriter(conn.getOutputStream());
        // 发送请求参数
        out.print(xml);
        // flush输出流的缓冲
        out.flush();
        // 定义BufferedReader输入流来读取URL的响应
        in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
    //使用finally块来关闭输出流、输入流
        out.close();
        in.close();
        return result;
		
	}
}
