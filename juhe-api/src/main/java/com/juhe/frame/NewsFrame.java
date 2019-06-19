package com.juhe.frame;


import com.juhe.entity.News;
import com.juhe.sevice.JuHeApiService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NewsFrame {
    private JPanel mainPanel;
    private JPanel navPanel;
    private JButton topBtn;
    private JButton sportBtn;
    private JButton fashionBtn;
    private JPanel centerPanel;
    private JPanel topPanel;
    private JPanel sportPanel;
    private JPanel fashionPanel;
    private JList list1;


    public NewsFrame() {

        CardLayout cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        //将三张卡加入主容器，并且指定名称
        centerPanel.add("top",topPanel);
        centerPanel.add("sports",sportPanel);
        centerPanel.add("fashion",fashionPanel);
        java.util.List<News> newsList = JuHeApiService.getNews("top");
        showData(newsList,topPanel);
        cardLayout.show(centerPanel, "top");
        topBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<News> newsList = JuHeApiService.getNews("top");
                showData(newsList,topPanel);
                cardLayout.show(centerPanel,"top");
            }
        });
        sportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<News> newsList = JuHeApiService.getNews("tiyu");
                showData(newsList,sportPanel);
                cardLayout.show(centerPanel,"sports");
            }
        });
        fashionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<News> newsList = JuHeApiService.getNews("shishang");
                showData(newsList,fashionPanel);
                cardLayout.show(centerPanel,"fashion");
            }
        });
    }
    public void showData(List<News> newsList, JPanel contentPanel){
        contentPanel.removeAll();
        int length = newsList.size();
        int row = length % 6 == 0 ? length / 6 : length / 6 + 1;
        GridLayout gridLayout = new GridLayout(row, 6, 15, 20);
        contentPanel.setLayout(gridLayout);
        for (News news : newsList) {
            JPanel jPanel = new JPanel();
            JLabel imgLabel = new JLabel();
            imgLabel.setText("<html><img src='" + news.getThumbnailPicS() + "' /></html>");
            JLabel titleLabel = new JLabel(news.getTitle());
            jPanel.add(imgLabel);
            jPanel.add(titleLabel);
            jPanel.setPreferredSize(new Dimension(200, 220));
            contentPanel.add(jPanel);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NewsFrame");
        frame.setContentPane(new NewsFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
