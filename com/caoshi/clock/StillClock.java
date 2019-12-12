package com.caoshi.clock;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 静态时钟类
 * Created by CaoShi on 2019/12/12 21:39
 */
public class StillClock extends JPanel {
  private int hour;
  private int minute;
  private int second;

  public StillClock() {
  }

  public StillClock(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
    repaint();
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
    repaint();
  }

  public int getSecond() {
    return second;
  }

  public void setSecond(int second) {
    this.second = second;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // 初始化时钟参数，圆的半径和圆心坐标
    int clockRadius = (int) (Math.min(getWidth(), getWidth()) * 0.5 * 0.8);
    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;

    // 画圆
    g.setColor(Color.black);
    g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
    g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
    g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
    g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);
    g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);

    // 画秒针
    int sLength = (int) (clockRadius * 0.8);
    int xSencond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
    int ySencond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
    g.setColor(Color.red);
    g.drawLine(xCenter, yCenter, xSencond, ySencond);

    // 画分针
    int mLength = (int) (clockRadius * 0.65);
    int xMinute = (int) (xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
    int yMinute = (int) (yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
    g.setColor(Color.blue);
    g.drawLine(xCenter, yCenter, xMinute, yMinute);

    // 画时针
    int hLength = (int) (clockRadius * 0.5);
    int xHour = (int) (xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
    int yHour = (int) (yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
    g.setColor(Color.BLACK);
    g.drawLine(xCenter, yCenter, xHour, yHour);

  }

  public void setCurrentTime() {
    // 创建当前时日历对象
    Calendar calendar = new GregorianCalendar();

    // 设置时分秒
    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);
  }

  public Dimension getPreferredSize() {
    return new Dimension(200, 200);
  }


  public static void main(String[] args) {
    JFrame frame = new JFrame("Test");
    frame.add(new StillClock());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }

}
