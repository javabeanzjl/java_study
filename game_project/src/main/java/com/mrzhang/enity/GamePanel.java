package main.java.com.mrzhang.enity;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    
    // 构造方法
    public GamePanel() {
    }
    
    // 设置背景等组件
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);// 清屏
        this.setBackground(Color.BLACK);// 设置背景色
        Data.header.paintIcon(this,g,25,11);// 绘制头部信息区域
        g.fillRect(25,75,850,600);// 绘制游戏区域
    }
}
