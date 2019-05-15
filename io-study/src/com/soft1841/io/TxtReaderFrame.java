package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * txt文件阅读器窗体
 * @author  xuyuan
 */
public class TxtReaderFrame  extends JFrame implements ActionListener {
    private  JTextField inputField;
    private  JButton confirmButton;
    private  JPanel topPanel;
    private  JTextArea contentArea;
    private JLabel imageLabel;
    private  Icon icon;

    public  TxtReaderFrame(){
        init();
        setTitle("文本阅读器");
        setLocationRelativeTo(null);
        setSize(new Dimension(640,900));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public  void  init(){
        Font font = new Font("微软雅黑",Font.PLAIN,40);
        //顶部面板
        inputField  = new JTextField(20);
        inputField  = new JTextField();
        inputField.setPreferredSize(new Dimension(190,40));
        confirmButton = new JButton("确认");
//指定按钮的大小
        confirmButton.setPreferredSize(new Dimension(100,40));
        topPanel = new JPanel();
        topPanel.add(inputField);
        topPanel.add(confirmButton);
        //给按钮注册监听
        confirmButton.addActionListener(this);
        add(topPanel,BorderLayout.NORTH);
//        //中间的多行文本
//        contentArea = new JTextArea();
//        add(contentArea,BorderLayout.CENTER);
        //图片的加入
        imageLabel = new JLabel();
        add(imageLabel,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new  TxtReaderFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取输入框的内容
        String filePath = inputField.getText().trim();
        //创建文件
        File file = new File(filePath);
        //使用三种方法将file中的内容读入
        InputStream in;
        byte[] bytes = null;
        try {
            in = new FileInputStream(file);
            bytes = new byte[(int) file.length()];
            in.read(bytes);
            icon = new ImageIcon(bytes);
            imageLabel.setIcon(icon);
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null,"IO操作异常");
        }
    }
}
