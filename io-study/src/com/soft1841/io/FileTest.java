package com.soft1841.io;


import java.io.File;

/**
 * 在d盘创建一个文件夹，在文件夹里面创建10个子文件夹
 * @author 许源 2019年3月25日
 */
public class FileTest {
    public static void main(String[] args) {
        String path = "D:Java";
        for (int i = 1; i <= 10; i++) {
            File folder = new File(path + "\\" + "chap" + i);
            if (!folder.exists()) {
                folder.mkdirs();
            }else {
            }
        }
    }
}
