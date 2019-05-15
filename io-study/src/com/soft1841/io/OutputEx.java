package com.soft1841.io;

import java.io.*;

public class OutputEx {
    public static void main(String[] args) throws IOException {
        String str = "I LOVE chenweiping";
        File file = new File("E://out2.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        //字节流
//        OutputStream outputStream = new FileOutputStream(file);
//        outputStream.write(str.getBytes());
//        outputStream.close();
        //字符流输出
        Writer writer  = new FileWriter(file);
        writer.write(str.toCharArray());
              writer.close();
        //打印流 将运行结果追加
//        OutputStream out = new FileOutputStream(file);
//        PrintStream printStream = new PrintStream(out);
//        printStream.println(str);
//        printStream.close();

    }


}
