/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author charith_ds
 */
public class TimeCounter {

    int startTime = 0;
    int stopTime = 0;
    int miliSeconds = 0;
    int seconds = 0;
    int minutes = 0;
//    int hours = 0;
    int elapsedTime = 0;
    int min_max_lapTime = 0;
    String miliSeconds_String = "";
    String seconds_String = "";
    String minutes_String = "";
//    String hours_String = "";
    String lapValues = "";
    JLabel displayTime = new JLabel();

    Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            //caculate time
            elapsedTime = elapsedTime + 10;
//            hours = elapsedTime / 360000;
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            miliSeconds = (elapsedTime / 10) % 100;
//            hours_String = String.format("%02d", hours);
            minutes_String = String.format("%02d", minutes);
            seconds_String = String.format("%02d", seconds);
            miliSeconds_String = String.format("%02d", miliSeconds);
            displayTime.setText(minutes_String +  " : " + seconds_String + " : " + miliSeconds_String);
            lapValues = minutes_String +  " : " + seconds_String + " : " + miliSeconds_String;
            
            min_max_lapTime = elapsedTime;
        }

    });

    public TimeCounter(JLabel displayTime) {
        this.displayTime = displayTime;
    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {

        timer.stop();
        elapsedTime = 0;
        miliSeconds = 0;
        seconds = 0;
        minutes = 0;
//        hours = 0;
//        hours_String = String.format("%02d", hours);
        minutes_String = String.format("%02d", minutes);
        seconds_String = String.format("%02d", seconds);
        miliSeconds_String = String.format("%02d", miliSeconds);
        displayTime.setText(minutes_String +  " : " + seconds_String + " : " + miliSeconds_String);
    }
    
    public void timeCounterMethod(JLabel displayTime) {
        this.displayTime = displayTime;
    }

}
