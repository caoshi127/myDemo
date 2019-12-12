package com.caoshi.clock;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  动画时钟
 * Created by CaoShi on 2019/12/12 23:21
 */
public class ClockAnimation extends StillClock {

  public ClockAnimation() {
    Timer timer = new Timer(1000, new TimerListener());
    timer.start();
  }


  private class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      setCurrentTime();
      repaint();
    }
  }


  public static void main(String[] args) {
    JFrame jFrame = new JFrame("ClockAnimation");
    ClockAnimation clock = new ClockAnimation();
    jFrame.add(clock);
//    jFrame.setLocationRelativeTo(null);
    int w = jFrame.getToolkit().getScreenSize().width;
    int h = jFrame.getToolkit().getScreenSize().height;
    jFrame.setLocation(w / 2 - 200, h / 2 - 200);

    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setSize(400, 400);
    jFrame.setVisible(true);

  }

  @Test
  public void test() {
    JFrame jFrame = new JFrame("ClockAnimation");
    int w = jFrame.getToolkit().getScreenSize().width;
    int h = jFrame.getToolkit().getScreenSize().height;

    System.out.println(w + "--" + h);
  }

}
