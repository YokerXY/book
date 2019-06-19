package com.sm.frame;
import com.sm.entity.Admin;
import com.sm.factory.ServiceFactory;
import com.sm.ui.ImgPanel;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisteredFrame extends  JFrame{
    private ImgPanel rootPanel;
    private JTextField nameField;
    private JTextField idField;
    private JTextField accountField;
    private JTextField passwordField;
    private JLabel nameLabel;
    private JLabel passwrdLabel;
    private JTextField answerField;
    private JLabel questionLabel;
    private JPanel questionPanel;
    private JButton 注册Button;
    private JButton 取消Button;
    private JButton 注册Button1;


    public RegisteredFrame(){
        rootPanel.setFileName("123.jpg");
        rootPanel.repaint();
        setTitle("管理员登陆界面");
        setContentPane(rootPanel);
        setSize(400, 626);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        注册Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin admin = new Admin();
                admin.setAdminName(nameField.getText());
                admin.setAccount(accountField.getText());
                admin.setPassword(passwordField.getText());
                try {
                    ServiceFactory.getAdminServiceInstance().insertGlyLogin(admin);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
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
