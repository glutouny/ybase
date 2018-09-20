package com.yl.util;

import com.yl.constants.HepCoreConstants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Title: HepGetRequestUtils
 * @Description:
 * @Author: 杨黎
 * @Date: 2018/9/20
 */
public class HepGetRequestUtils {

    private final static Logger LOG = LoggerFactory.getLogger(HepGetRequestUtils.class);
    public static String sendGetRequest(final String url,String username,String password,int connectTimeout) throws IOException {
        String result = null;
        final String auth = username + ":" + password;
        //对其进行加密
        final byte[] base64 = Base64.encodeBase64(auth.getBytes());
        final String strBase64 = new String(base64);
        StringBuffer sb = null;
        String output = null;
        HttpURLConnection httpConnection = null;
        BufferedReader responseBuffer = null;
        try
        {
            LOG.info("----HTTP GET Request Start The Url is--- : " + url);
            httpConnection = (HttpURLConnection) new URL(url).openConnection();
            httpConnection.setRequestProperty("Authorization", "Basic " + strBase64);
            httpConnection.setRequestProperty("Accept", "application/json");
            httpConnection.setRequestProperty("Charset", "UTF-8");
            httpConnection.setConnectTimeout(defVal(connectTimeout, HepCoreConstants.CONNECT_TIMEOUT));
            //httpConnection.setReadTimeout(5000);
            httpConnection.setRequestMethod("GET");
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
            if(responseBuffer!=null) {
                responseBuffer.close();
            }
            httpConnection.disconnect();
        }

    }
    public static String sendGetRequestOnlyUrl(final String url,int connectTimeout) throws IOException {
        String result = null;
        //final String auth = USERNAME + ":" + PASSWORD;
        //对其进行加密
        //final byte[] base64 = Base64.encodeBase64(auth.getBytes());
        //final String strBase64 = new String(base64);
        StringBuffer sb = null;
        String output = null;
        HttpURLConnection httpConnection = null;
        BufferedReader responseBuffer = null;
        try
        {
             LOG.info("----HTTP GET Request Start The Url is--- : " + url);
             httpConnection = (HttpURLConnection) new URL(url).openConnection();
            //httpConnection.setRequestProperty("Authorization", "Basic " + strBase64);
            httpConnection.setRequestProperty("Accept", "application/json");
            httpConnection.setRequestProperty("Charset", "UTF-8");
            httpConnection.setConnectTimeout(defVal(connectTimeout, HepCoreConstants.CONNECT_TIMEOUT));
            //httpConnection.setReadTimeout(5000);
            httpConnection.setRequestMethod("GET");
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
            //释放资源
            responseBuffer.close();
            httpConnection.disconnect();

        }

    }

    private static <T> T defVal(T value, T deful) {
        return ObjectUtils.defaultIfNull(value, deful);
    }
}
