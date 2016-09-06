package thetekst.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    JFrame frame;

    public static void main(String[] args) {
        new Main().show();
    }

    private void show() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, new Card());
//
        frame.getContentPane().add(BorderLayout.SOUTH, new MyCanvas());
        frame.setSize(300, 300);
        frame.setVisible(true);
        drawPanel();
    }

    class MyCanvas extends JComponent {

        public void paint(Graphics g) {
            g.setColor(Color.white);
            g.fillRect (70, 70, 100, 100);
//            g.drawRect(70, 70, 100, 100);
        }
    }

    private void drawPanel() {
        Thread thread = new Thread(new MyRun());
        thread.run();
    }

    class MyRun implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    frame.repaint();
//                    System.out.println("run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    class KeyboardListenter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String str = actionEvent.paramString();
            System.out.println(str);
        }
    }
}
