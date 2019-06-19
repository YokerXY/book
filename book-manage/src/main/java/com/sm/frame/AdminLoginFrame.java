package com.sm.frame;

import com.sm.entity.Admin;
import com.sm.factory.DAOFactory;
import com.sm.factory.ServiceFactory;
import com.sm.ui.ImgPanel;
import com.sm.utils.ResultEntity;

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
    private JRadioButton 学生RadioButton;
    private JRadioButton 管理员RadioButton;

    public AdminLoginFrame() {
        rootPanel.setFileName("34.png");
        rootPanel.repaint();
        setTitle("管理员登陆界面");
        setContentPane(rootPanel);
        setSize(918, 626);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        ButtonGroup group = new ButtonGroup();
        group.add(学生RadioButton);
        group.add(管理员RadioButton);

        登录Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (管理员RadioButton.isSelected()) {
                    //获得输入的账号密码
                    String account = accountField.getText().trim();
                    String password = new String(passwordField.getPassword()).trim();
                    ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account, password);
                    JOptionPane.showMessageDialog(rootPanel, resultEntity.getMessage());

                    //登录成功，进入主界面，并关闭登录界面
                    if (resultEntity.getCode() == 0) {
                        try {
                            new AdminMainFrame1(DAOFactory.getAdminDAOInstance().getAdminByAccount(account));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        AdminLoginFrame.this.dispose();

                    } else if (resultEntity.getCode() == 1) {
                        //密码错误，清空密码框
                        passwordField.setText("");
                    } else {
                        //账号错误，清空两个输入框
                        accountField.setText("");
                        passwordField.setText("");
                    }
                } else {
                    if (学生RadioButton.isSelected()) {
                        //获得输入的账号密码
                        String account = accountField.getText().trim();
                        String password = new String(passwordField.getPassword()).trim();
                        //员工登录
                        ResultEntity resultEntity1 = ServiceFactory.getStudentServiceInstance().stuLogin(account, password);
                        JOptionPane.showMessageDialog(rootPanel, resultEntity1.getMessage());
                        //登录成功，进入主界面，并关闭登录界面
                        if (resultEntity1.getCode() == 0) {
                            try {
                                new AdminMainFrame2(DAOFactory.getStudentDAOInstance().getStuLoginByAccount(account));
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                            AdminLoginFrame.this.dispose();

                        } else if (resultEntity1.getCode() == 1) {
                            //密码错误，清空密码框
                            passwordField.setText("");
                        } else {
                            //账号错误，清空两个输入框
                            accountField.setText("");
                            passwordField.setText("");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"请选择您的角色！");
                    }
                }

            }
        });
        取消Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLoginFrame.this.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new AdminLoginFrame();
    }
}
