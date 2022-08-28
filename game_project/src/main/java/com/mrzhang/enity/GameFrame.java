package main.java.com.mrzhang.enity;

import javax.swing.*;

public class GameFrame {
    public static void main(String[] args) {
        // 1、绘制一个静态窗口 JFrame
        JFrame frame = new JFrame("张佳乐的贪吃蛇小游戏");
        // 2、绘制大小和位置
        frame.setBounds(10,10,900,720);
        // 3、设置窗口大小不可调整
        frame.setResizable(false);
        // 4、设置关闭事件，游戏可以关闭
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 5、设置JPanel画布
        frame.add(new GamePanel());


        // 将窗口展示出来
        frame.setVisible(true);
    }
}
