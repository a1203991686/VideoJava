/*
 * 与com.anonymousInnerClass.AnonymousInnerClassTest.java形成对应
 */
package com.volume1.unit6.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * This program demonstrates the use of innner classes
 * @version 1.10 2018-7-21
 * @author a1203
 */

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        //keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals
 */
class TalkingClock{
    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     * @param interval the interval between messages (in milliseconds)
     * @param beep true if the clock should beep
     */
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock
     */
    public void start(){
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }



    public class TimePrinter implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is" + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}