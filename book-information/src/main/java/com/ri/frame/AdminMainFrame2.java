package com.ri.frame;

import com.ri.entrty.ReaderInformation;
import com.ri.entrty.Student;
import com.ri.factory.ServiceFactory;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminMainFrame2 extends JFrame {
    private JPanel rootPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel Panel1;
    private JPanel contacPanel;
    private JLabel nameLabel;
    private JLabel roalLabel;
    private JLabel dateLabel;
    private JLabel avatarLabel;
    private JLabel emailLabel;
    private JLabel mobilLabel;
    private JPanel bookPanel;
    private JLabel idLabel;
    private String readerId;


    public AdminMainFrame2(Student stuLoginByAccount){
        setTitle("学生登陆界面");
        setContentPane(rootPanel);
        setSize(918, 626);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        final CardLayout cardLayout = (CardLayout) contacPanel.getLayout();

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card1");
                showReaderInformation();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card2");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card3");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card4");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminLoginFrame();
                AdminMainFrame2.this.dispose();
            }
        });
        readerId=stuLoginByAccount.getLoginId().toString();
    }

    public void showReaderInformation(){

        List<ReaderInformation> readerInformationList = ServiceFactory.getReaderServiceInstance().selsetAllIn(readerId);
        for (ReaderInformation readerInformation : readerInformationList){
            JPanel jPanel = new JPanel();
            nameLabel.setText(readerInformation.getReaderName());
//            roalLabel.setText(readerInformation.getRole());

            JLabel jLabel1 = new JLabel();
            JLabel jLabel2 = new JLabel();
            jLabel1.setText("<html><img src='"+readerInformation.getAvatar()+"'/></html>");
            jLabel2.setText(readerInformation.getBookName());
            System.out.println(readerInformation.getAvatar());
            jPanel.add(jLabel1);
            jPanel.add(jLabel2);

            bookPanel.add(jPanel);




        }
    }
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        new  AdminMainFrame2(new Student());
    }
}
