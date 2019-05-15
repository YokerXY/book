package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 图片窗体程序
 * @author 许源
 * 2019年3月26日
 */
public class ImageFrame extends JFrame  {
    private JPanel topPanel;
    private JButton[] buttons;
    private JLabel imagLabel;
    private Icon icon;
    private JLabel content;
    private JLabel lj;

    public ImageFrame() {
        init();
        setTitle("图片窗体");
        setSize(1000, 600);
        //窗体自动居中
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //设置布局，放置组件
    public void init() {
        topPanel = new JPanel();
        buttons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton("按钮" + i + 1);
            topPanel.add(buttons[i]);
        }
        add(topPanel, BorderLayout.NORTH);
        imagLabel = new JLabel("图片");
        File srcfile = new File("D:/pp.png");
        InputStream in;
        byte[]bytes =null;
        try {
            in = new FileInputStream(srcfile);
             bytes = new byte[(int) srcfile.length()];
            in.read(bytes);
        }catch (IOException e){
            System.out.println("IO异常");
        }
      icon =new ImageIcon(bytes);
        imagLabel.setIcon(icon);
    add(imagLabel, BorderLayout.CENTER);
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String date =format.format(new Date());
       content=new JLabel(date);
       add(content,BorderLayout.NORTH);
       //路径的获取
        File srcFile1= new File("D:pp.png");
        String ljable=srcFile1.getAbsolutePath();
        lj =new JLabel(ljable);
        add(lj,BorderLayout.EAST);



}
    public static void main(String[] args) {
        new ImageFrame();

    }

}
