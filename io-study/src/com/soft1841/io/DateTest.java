package com.soft1841.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建指定目录文件夹
 * @author 许源
 * 2019年3月15日
 */
public class DateTest {
    public static void main(String[] args) throws IOException {
        //获取时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        System.out.println(date);
        File path = new File("E:\\Test_" + date);
        if (!path.exists()) {
            path.mkdirs();
        }
        File file = new File(path + "/" + "HelloWorld" + date);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}