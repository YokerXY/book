package com.ri.frame;

import com.ri.entrty.Admin;
import com.ri.entrty.Book;
import com.ri.factory.ServiceFactory;
import com.ri.ui.ImgPanel;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AdminMainFrame1 extends JFrame {
    private ImgPanel rootPanel;
    private JPanel mianPanel;
    private JButton 图书管理Button;
    private JButton 账号注册Button;
    private JButton 借阅管理Button;
    private JButton 还书管理Button;
    private JPanel contacPanel;
    private JLabel timerLabel;
    private JLabel xyLabel;
    private JLabel ontimeLabel;
    private JPanel bookPabel;
    private JButton 统计分析Button;
    private JPanel borrowTabelPanel;
    private JPanel returnTabelPanel;
    private Admin admin;

    public AdminMainFrame1(Admin adminByAccount) {
        rootPanel.setFileName("主界面.jpg");
        rootPanel.repaint();
        this.admin = adminByAccount;
        setTitle("管理员登陆界面");
        setContentPane(rootPanel);
        setSize(918, 626);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);

        OnTimeThread onTimeThread = new OnTimeThread();
        onTimeThread.setOntimeLabel(ontimeLabel);
        new Thread(onTimeThread).start();

        final CardLayout cardLayout = (CardLayout) contacPanel.getLayout();

        图书管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card1");
                List<Book> bookList = ServiceFactory.getBookServiceInstance().selectAllBook();
                showBookPanel(bookList);
            }
        });
        账号注册Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card2");
                new RegisteredFrame();
            }
        });
        借阅管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card3");
            }
        });
        还书管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card4");
            }
        });

        统计分析Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card5");
            }
        });
        TimerTask timerTask = null;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("当前系统时间为：" + "yyyy/MM/dd    HH:mm:ss");
                String timeString = sdf.format(date);
                timerLabel.setText(timeString);
                xyLabel.setText(adminByAccount.getAdminName());
            }
        };
        java.util.Timer timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
    }

    class OnTimeThread implements Runnable {
        private JLabel ontimeLabel;

        public void setOntimeLabel(JLabel ontimeLabel) {
            this.ontimeLabel = ontimeLabel;
        }

        public JLabel getOntimeLabel() {
            return ontimeLabel;
        }

        @Override
        public void run() {
            /**
             * ontimeLabel的实现（在线时长）
             */
            int d = 0;
            int h = 0;
            int m = 0;
            int s = 0;
            while (s != 60) {
                try {
                    Thread.sleep(1000);
                    s = s + 1;
                    ontimeLabel.setText("当前在线时长：" + d + "天  " + h + "小时  " + m + "分钟   " + s + "秒");
                    if (s == 60) {
                        s = 0;
                        m = m + 1;
                        ontimeLabel.setText("当前在线时长：" + d + "天  " + h + "小时  " + m + "分钟   " + s + "秒");
                        if (m == 60) {
                            m = 0;
                            h = h + 1;
                            ontimeLabel.setText("当前在线时长：" + d + "天  " + h + "小时  " + m + "分钟   " + s + "秒");
                            if (h == 24) {
                                h = 0;
                                d = d + 1;
                                ontimeLabel.setText("当前在线时长：" + d + "天  " + h + "小时  " + m + "分钟   " + s + "秒");
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void showBookPanel(java.util.List<Book> bookList) {
        bookPabel.removeAll();
        int len = bookList.size();
        int row = len % 4 == 0 ? len / 4 : len / 4 + 1;
        GridLayout gridLayout = new GridLayout(row, 2, 30, 20);
        bookPabel.setLayout(gridLayout);
        for (Book book : bookList) {
            JPanel jPanel = new ImgPanel();
//            jPanel.setFileName("34.jpg");
            jPanel.setPreferredSize(new Dimension(100, 200));
            jPanel.setLayout(new GridLayout(10, 1));

            JLabel jLabel0 = new JLabel("    ");
            JLabel jLabel = new JLabel("                 图书信息");
            jLabel.setForeground(new Color(255, 69, 0));
            jLabel.setFont(new Font(null, Font.BOLD, 29));
            Font font = new Font(null, Font.BOLD, 24);

            JPanel jPanel1 = new JPanel();
            jPanel1.setLayout(new BorderLayout());
            JLabel jLabel1 = new JLabel("<html><img src='" + book.getCover()+ "'/></html>");
            JLabel jLabel2 = new JLabel("         书名：" + book.getBookName());
            JTextArea jLabel3 = new JTextArea("         概要：" + book.getSummary());
            JLabel jLabel4 = new JLabel("         作者：" + book.getAuthor());
            JLabel jLabel5 = new JLabel("         库存：" + book.getStock());
            JLabel jLabel6 = new JLabel("         价格：" + book.getPrice());


            jLabel1.setFont(font);
            jLabel2.setFont(font);
            jLabel3.setFont(font);
            jLabel4.setFont(font);
            jLabel5.setFont(font);
            jLabel6.setFont(font);

            jLabel3.setForeground(new Color(255, 69, 0));

            jPanel.add(jLabel0);
            jPanel.add(jLabel0);
            jPanel.add(jLabel0);
            jPanel.add(jLabel);
//            jPanel.add(jLabel1);
            jPanel.add(jLabel2);
            jPanel.add(jLabel3);
            jPanel.add(jLabel5);

            jPanel.add(jLabel6);
            jPanel.add(jLabel4);

            jPanel1.add(jLabel1);


            jPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 3) {
                        int n = JOptionPane.showConfirmDialog(jPanel, "是否确认删除?", "确认对话框", JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION) {
                            bookPabel.remove(jPanel);
                            bookPabel.remove(jPanel1);
                            bookPabel.repaint();
                            ServiceFactory.getBookServiceInstance().selectBook(book.getId());
                        }
                    }
                }
            });
            bookPabel.add(jPanel1);
            bookPabel.add(jPanel);
            bookPabel.revalidate();

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
         new AdminMainFrame1(new Admin());


    }
}
