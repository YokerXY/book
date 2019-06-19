package com.sm.frame;

import com.sm.entity.StuLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AdminMainFrame2 extends  JFrame{
    private JPanel rootPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel centerPanel;
    private JLabel timeLabel;

    public AdminMainFrame2(StuLogin stuLoginByAccount){
        setTitle("学生登陆界面");
        setContentPane(rootPanel);
        setSize(918, 626);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        CardLayout cardLayout = (CardLayout) centerPanel.getLayout();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"Card1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"Card2");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"Card3");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"Card4");
            }

        });
        Font font = new Font("微软雅黑", Font.BOLD, 18);
        TimerTask timerTask = null;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("当前系统时间为：" + "yyyy/MM/dd    HH:mm:ss");
                String timeString = sdf.format(date);
                timeLabel.setText(timeString);

            }
        };
        java.util.Timer timer = new Timer();
        timer.schedule(timerTask, 0, 1000);

    }
    public static void main(String[] args) {
        new  AdminMainFrame2(new StuLogin());
    }
}
