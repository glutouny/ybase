package com.yl.test;


import org.apache.commons.io.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/9/30  11:03
 */
public class TestUrl {

    public static void main(String[] args) {
//        System.out.println(getImageBinary("http://172.20.0.239:8089/hem/33/421319000/color/00.jpg"));
//        List<String> fileStringLines = new ArrayList<>();
//        try {
//            File file = new File("C:\\Users\\YLYX\\Desktop\\HT413SLSPCS.20190924.20190920173715116");
//            fileStringLines = FileUtils.readLines(file,"GBK");
//            System.out.println(fileStringLines.get(0).substring(1,5)+"==");
//            System.out.println("12345:==="+fileStringLines.size());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String a = "3";
        System.out.println(Double.valueOf(a).longValue());
    }

    public static byte[] getImageBinary(String imagePath) {
        try {
            URL urlConet = new URL(imagePath);
            HttpURLConnection con = (HttpURLConnection)urlConet.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(4 * 1000);
            con.connect();
            InputStream inStream = con .getInputStream();    //通过输入流获取图片数据
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int len = 0;
            while( (len=inStream.read(buffer)) != -1 ){
                outStream.write(buffer, 0, len);
            }
            inStream.close();
            byte[] data =  outStream.toByteArray();
            return data;
        } catch (IOException e) {
            System.out.println("=====");
            e.printStackTrace();
        }
        return null;
    }
}
