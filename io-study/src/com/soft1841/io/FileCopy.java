package com.soft1841.io;

import java.io.*;
import java.util.UUID;

/**
 * 文件复制的操作
 * @author 许源
 * 2019年3月26日
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        File srcfile =new File("E:/bg.jpg");
        String srcFileName = srcfile.getName();
        int position =srcFileName.indexOf(".");
        //取得源文件扩展名.'
        String suffixName =srcFileName.substring(position +1);
        //定位位置
        String newName = UUID.randomUUID().toString();
        //新的主文件名
        File destfile =new File("E:/"+newName+"."+suffixName);
        //指定目标文件
        byte[] bytes =new byte[(int)srcfile.length()];
        //创建字节输入流
        InputStream in  = new FileInputStream(srcfile);
        in.read(bytes);
        //创建字节输出流
        OutputStream out =new FileOutputStream(destfile);
        out.write(bytes);
        in.close();
        out.close();

    }
}
