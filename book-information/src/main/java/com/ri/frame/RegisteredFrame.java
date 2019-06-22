package com.ri.frame;

import com.ri.entrty.Admin;
import com.ri.factory.ServiceFactory;
import com.ri.ui.ImgPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisteredFrame extends  JFrame {
    private ImgPanel rootPanel;
    private JTextField nameField;
    private JTextField accountField;
    private JTextField passwordField;
    private JButton 注册Button;
    private JButton 取消Button;
    private JButton 注册Button1;


    public RegisteredFrame() {
        rootPanel.setFileName("注册.jpg");
        rootPanel.repaint();
        setTitle("管理员登陆界面");
        setContentPane(rootPanel);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        注册Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin admin = new Admin();
                admin.setAdminName(nameField.getText());
                admin.setAccount(accountField.getText());
                admin.setPassword(passwordField.getText());

                    ServiceFactory.getAdminServiceInstance().insertGlyLogin(admin);

                RegisteredFrame.this.dispose();
            }
        });
        取消Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisteredFrame.this.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new RegisteredFrame();
    }
}
