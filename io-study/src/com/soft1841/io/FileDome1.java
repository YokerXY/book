package com.soft1841.io;

import java.io.File;
import java.io.IOException;

/**
 *
 * File的练习
 * @author 许源
 * 2019年3月25日
 */
public class FileDome1 {
    public static void main(String[] args) throws IOException {
        File file = new File("E: /READEME.md");
        //判断如果file不存在，则创建新文件
        if (!file.exists()){
            file.createNewFile();
        }

    }
}
