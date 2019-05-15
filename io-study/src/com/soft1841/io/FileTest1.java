package com.soft1841.io;

import java.io.File;
import java.io.IOException;

public class FileTest1 {
    public static void main(String[] args) throws IOException {
        String[] strings ={"image","video","document"};
        for (int i=0;i<strings.length;i++){
            File path =new File("E:/HEEL/"+strings[i]);
            if (!path.exists()){
                path.mkdirs();
            }
            }
        }
    }

