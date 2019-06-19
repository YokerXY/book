package com.sm.frame;

import com.sm.entity.Admin;
import com.sm.entity.ResultEntity;
import com.sm.factory.DAOFactory;
import com.sm.factory.ServiceFactory;
import com.sm.ui.ImgPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AdminLoginFrame extends JFrame{
    private ImgPanel rootPanel;
    private JLabel accountLabel;
    private JPasswordField passwordField;
    private JTextField accountField;
    private JLabel passowrdLabel;
    private JButton 取消Button;
    private JButton 登录Button;
    public AdminLoginFrame(){
        rootPanel.setFileName("34.jpg");
        rootPanel.repaint();
        setTitle("管理员登陆界面");
        setContentPane(rootPanel);
        setSize(918,626);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        登录Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获得输入的账号和密码，注意密码框组件的使用方法
                String account = accountField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account, password);
                JOptionPane.showMessageDialog(rootPanel, resultEntity.getMessage());
                //登录成功，进入主界面，并关闭登录界面
                if (resultEntity.getCode() == 0) {
                    try {
                        new AdminMainFrame((DAOFactory.getAdminDAOInstance().getAdminByAccount(account)));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    AdminLoginFrame.this.dispose();

                } else if (resultEntity.getCode() == 1) {  //密码错误，清空密码框
                    passwordField.setText("");
                } else {   //账号错误，清空两个输入框
                    accountField.setText("");
                    passwordField.setText("");
                }
            }
        });
        取消Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountField.setText("");
                passwordField.setText("");

            }
        });
    }

    public static void main(String[] args) {
        new AdminLoginFrame();
    }
}
