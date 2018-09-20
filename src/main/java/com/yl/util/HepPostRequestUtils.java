package com.yl.util;

import com.yl.constants.HepCoreConstants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Title: HepOaPostUtils
 * @Author: 杨黎
 * @Date: 2018/9/20
 * @Date: 2018/3/8 18:55
 */
public class HepPostRequestUtils {

    private static final Logger LOG = LoggerFactory.getLogger(HepPostRequestUtils.class);

    /**
     * POST请求，没有设置超时
     * @param url
     * @param json
     * @return
     */
    public static String httpPost(final String url, final String json,String userName,String password) throws IOException {
        String result = null;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try
        {
            final String str = userName + ":" + password;
            //对其进行加密
            final byte[] base64 = Base64.encodeBase64(str.getBytes());
            final String strBase64 = new String(base64);
            //获得URL，打开连接
            final URL urlStr = new URL(url);
            LOG.info("----------------url-----" + urlStr);
            connection = (HttpURLConnection) urlStr.openConnection();
            //设置通用的请求属性
            connection.setRequestProperty("Authorization", "Basic " + strBase64);
            connection.setRequestProperty("Connection", "Keep-Alive");
            //connection.setRequestProperty("user-agent", "Mozilla/5.0");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Accept", "application/json");// 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json; Charset=UTF-8"); // 设置发送数据的格式
            connection.connect();
            LOG.info("-----------------------------connection.connect()-----------------");
            //POST
            final OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            //发送数据
            out.write(json);
            //LOG.info("============传递的参数=" + json);
            out.flush();
            out.close();
            LOG.info("--------------------发送请求-----------------");
            //读取响应
            if (connection.getResponseCode() != 200)
            {
                LOG.error("HTTP POST Request Failed with Error code : " + connection.getResponseCode());
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            LOG.info("--------------------接收请求-----------------");
            String lines;
            final StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null)
            {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }

            result = sb.toString();
            //LOG.info("--------------------POST--result:" + result);
            return result;
        }
        catch (final Exception e)
        {
            LOG.error("Send infomation to sap request failed... " + e.getMessage());
            e.printStackTrace();
        }finally {
            if (null!=reader){
                reader.close();
            }
            if (null!=connection){
                // 断开连接
                connection.disconnect();
            }
        }
        return result;
    }


    /**
     * POST请求，有设置超时
     * @param urls
     * @param json
     * @return
     */
    public static String httpPostLong(final String urls, final String json,String userName,String password,int connectTimeout)
            throws IOException {
        String result = null;
        HttpURLConnection connection = null;
        OutputStreamWriter out = null;
        BufferedReader reader = null;
        try
        {
            final String str = userName + ":" + password;
            //对其进行加密
            final byte[] base64 = Base64.encodeBase64(str.getBytes());
            final String strBase64 = new String(base64);
            //获得URL，打开连接
            final URL url = new URL(urls);
            LOG.info("----------------url-----" + url);
            connection = (HttpURLConnection) url.openConnection();
            //设置通用的请求属性
            connection.setRequestProperty("Authorization", "Basic " + strBase64);
            connection.setRequestProperty("Connection", "Keep-Alive");
            //connection.setRequestProperty("user-agent", "Mozilla/5.0");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setConnectTimeout(defVal(connectTimeout, HepCoreConstants.CONNECT_TIMEOUT));
            connection.setReadTimeout(600000);
            connection.setRequestProperty("Accept", "application/json");// 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json; Charset=UTF-8"); // 设置发送数据的格式
            connection.connect();
            LOG.info("-----------------------------connection.connect()-----------------");
            //POST
            out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            //发送数据
            out.write(json);
            //LOG.info("============传递的参数=" + json);
            out.flush();
            out.close();
            LOG.info(
                    "--------------------发送请求-----------------" + connection.getConnectTimeout() + "--" + connection.getReadTimeout());
            //读取响应
            if (connection.getResponseCode() != 200)
            {
                LOG.error("HTTP POST Request Failed with Error code : " + connection.getResponseCode());
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            LOG.info("--------------------接收请求-----------------");
            String lines;
            final StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null)
            {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            result = sb.toString();
            return result;
        }
        catch (final Exception e)
        {
            LOG.error("Send infomation to sap request failed... " + e.getMessage());
            e.printStackTrace();
        }finally {
            if (null!=reader){
                reader.close();
            }
            if (null!=connection){
                // 断开连接
                connection.disconnect();
            }
        }
        return result;
    }

    /**
     * POST请求，有设置超时,没有验证的请求
     * @param urls
     * @param json
     * @return
     */
    public static String httpPostLongNoAthentication(final String urls, final String json,int connectTimeout)
            throws IOException {
        String result = null;
        HttpURLConnection connection = null;
        OutputStreamWriter out = null;
        BufferedReader reader = null;
        try
        {
            //对其进行加密
            //获得URL，打开连接
            final URL url = new URL(urls);
            LOG.info("----------------url-----" + url);
            connection = (HttpURLConnection) url.openConnection();
            //设置通用的请求属性
            connection.setRequestProperty("Connection", "Keep-Alive");
            //connection.setRequestProperty("user-agent", "Mozilla/5.0");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setConnectTimeout(defVal(connectTimeout, HepCoreConstants.CONNECT_TIMEOUT));
            connection.setReadTimeout(600000);
            connection.setRequestProperty("Accept", "application/json");// 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json; Charset=UTF-8"); // 设置发送数据的格式
            connection.connect();
            LOG.info("-----------------------------connection.connect()-----------------");
            //POST
            out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            //发送数据
            out.write(json);
            //LOG.info("============传递的参数=============" + json);
            out.flush();
            out.close();
            LOG.info(
                    "--------------------发送请求-----------------" + connection.getConnectTimeout() + "--" + connection.getReadTimeout());
            //读取响应
            if (connection.getResponseCode() != 200)
            {
                LOG.error("HTTP POST Request Failed with Error code : " + connection.getResponseCode());
                return connection.getResponseCode()+"";
            }
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            LOG.info("--------------------接收请求-----------------");
            String lines;
            final StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null)
            {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            result = sb.toString();
            return result;
        }
        catch (final Exception e)
        {
            LOG.error("Send infomation to sap request failed... " + e.getMessage());
            e.printStackTrace();
        }finally {
            if (null!=reader){
                reader.close();
            }
            if (null!=connection){
                // 断开连接
                connection.disconnect();
            }
        }
        return result;
    }


    /**
     * POST请求，有设置超时,没有验证的请求
     * @param urls
     * @param json
     * @return
     */
    public static String httpPostLongNoAthenticationAndAuthorization(final String urls, final String json,int connectTimeout,String token)
            throws IOException {
        String result = null;
        HttpURLConnection connection = null;
        OutputStreamWriter out = null;
        BufferedReader reader = null;
        try
        {
            //对其进行加密
            //获得URL，打开连接
            final URL url = new URL(urls);
            LOG.info("----------------url-----" + url);
            connection = (HttpURLConnection) url.openConnection();
            //设置通用的请求属性
            connection.setRequestProperty("Connection", "Keep-Alive");
            //connection.setRequestProperty("user-agent", "Mozilla/5.0");
            connection.setRequestProperty("Authorization", "Bearer "+token);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setConnectTimeout(defVal(connectTimeout, HepCoreConstants.CONNECT_TIMEOUT));
            connection.setReadTimeout(600000);
            connection.setRequestProperty("Accept", "application/json");// 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json; Charset=UTF-8"); // 设置发送数据的格式
            connection.connect();
            LOG.info("-----------------------------connection.connect()-----------------");
            //POST
            out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            //发送数据
            out.write(json);
            //LOG.info("============传递的参数=============" + json);
            out.flush();
            out.close();
            LOG.info(
                    "--------------------发送请求-----------------" + connection.getConnectTimeout() + "--" + connection.getReadTimeout());
            //读取响应
            if (connection.getResponseCode() != 200)
            {
                LOG.error("HTTP POST Request Failed with Error code : " + connection.getResponseCode());
                return connection.getResponseCode()+"";
            }
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            LOG.info("--------------------接收请求-----------------");
            String lines;
            final StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null)
            {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            result = sb.toString();
            return result;
        }
        catch (final Exception e)
        {
            LOG.error("Send infomation to sap request failed... " + e.getMessage());
            e.printStackTrace();
        }finally {
            if (null!=reader){
                reader.close();
            }
            if (null!=connection){
                // 断开连接
                connection.disconnect();
            }

        }
        return result;
    }
    /**
     * POST请求，有设置超时没有密码验证的请求
     * @param url
     * @return
     */
    public static String sendPostRequestOnlyUrl(final String url,int connectTimeout )
            throws IOException {
        String result = null;
        //final String auth = USERNAME + ":" + PASSWORD;
        //对其进行加密
        //final byte[] base64 = Base64.encodeBase64(auth.getBytes());
        //final String strBase64 = new String(base64);
        StringBuffer sb = null;
        String output = null;
        BufferedReader responseBuffer = null;
        HttpURLConnection httpConnection = null;
        try
        {
            LOG.info("----HTTP GET Request Start The Url is--- : " + url);
            httpConnection = (HttpURLConnection) new URL(url).openConnection();
            //httpConnection.setRequestProperty("Authorization", "Basic " + strBase64);
            httpConnection.setRequestProperty("Accept", "application/json");
            httpConnection.setRequestProperty("Charset", "UTF-8");
            httpConnection.setConnectTimeout(defVal(connectTimeout, HepCoreConstants.CONNECT_TIMEOUT));
            //httpConnection.setReadTimeout(5000);
            httpConnection.setRequestMethod("POST");
            if (httpConnection.getResponseCode() != 200)
            {
                LOG.error("HTTP GET Request Failed with Error code : " + httpConnection.getResponseCode());
                return result;
            }
            responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));
            sb = new StringBuffer();
            while ((output = responseBuffer.readLine()) != null)
            {
                sb.append(output);
            }
            result = sb.toString();
            return result;
        }
        catch (final Exception ex)
        {
            LOG.error("--------HepSapRestUtils failure--------" + ex.getMessage());
            ex.printStackTrace();
            return result;
        }finally {
            if (null!=responseBuffer){
                responseBuffer.close();
            }
            if (null!=httpConnection){
                // 断开连接
                httpConnection.disconnect();
            }
        }

    }

    /**
     * 没有验证的GET请求
     * @param url
     * @param param
     * @return
     */
    public static String httpGetWithUrl(final String url, final String param)
    {
        String result = "";
        BufferedReader in = null;
        try
        {
            final String urlNameString = url + "?" + param;
            LOG.info("---------the all url:" + urlNameString);
            final URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            final URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
            {
                result += line;
            }
        }
        catch (final Exception e)
        {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (final Exception e2)
            {
                e2.printStackTrace();
            }
        }
        return result;
    }

    private static <T> T defVal(T value, T deful) {
        return ObjectUtils.defaultIfNull(value, deful);
    }
}
