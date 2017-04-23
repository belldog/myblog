package com.zjw.blog.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * Created by Administrator on 2017/3/15.
 */
public class Base64ImageUtil {

    //图片转化成base64字符串
    public static String GetImageStr(String imgFile) {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        // String imgFile = "d://test.jpg";//待处理的图片
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    public static InputStream GenerateImage(String base64string) {
        if (base64string == null) //图像数据为空
            return null;

        ByteArrayInputStream stream = null;
        BASE64Decoder decoder = new BASE64Decoder();

        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(base64string);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }

            stream = new ByteArrayInputStream(b);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }

        return stream;
    }

    //base64字符串转化成图片
    public static boolean GenerateImage(String imgStr, String imgFilePath) {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            //生成jpeg图片
            // String imgFilePath = "d://222.jpg";//新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //base64字符串转化成图片
    public static boolean GenerateImage(byte[] img, String imgFilePath) {   //对字节数组字符串进行Base64解码并生成图片
        if (img == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            for (int i = 0; i < img.length; ++i) {
                if (img[i] < 0) {//调整异常数据
                    img[i] += 256;
                }
            }
            //生成jpeg图片
            // String imgFilePath = "d://222.jpg";//新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(img);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
