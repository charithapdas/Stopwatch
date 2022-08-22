/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatch;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import static stopwatch.MyStopwatch.lapTimeCounter;
import static stopwatch.MyStopwatch.mainTimeCounter;

/**
 *
 * @author charith_ds
 */
public class GridValue {

    static boolean activeFrames = false;
    static int max_lapValue = 0, min_lapValue = 0;
    static int max_lapNumber = 0, min_lapNumber = 0;
    static int lapNumberGap = 0;
    static int lLV_1_lenght = 0;
    static int lapNumber = 0;
    static String lastLapValues_1 = "", lastLapValues_2 = "";
    static String gridStore = "";
    static StyledDocument doc = new DefaultStyledDocument();

    static ArrayList<Integer> lap_List = new ArrayList<>();

    static void gridDisplay(String lapNumberTime, String overAlltime, boolean frame1Active) {
        String space_1 = "                       ";
        lastLapValues_1 = "     " + String.format("%02d", lapNumber) + "\t\t      " + lapNumberTime + space_1 + overAlltime;
        if (frame1Active) {
            lastLapValues_2 = lastLapValues_1 + "\n" + MyStopwatch.lapDetails.getText();
            MyStopwatch.lapDetails.setText(lastLapValues_2);
            lLV_1_lenght = lastLapValues_1.length() + 1;
            MyStopwatch.lapDetails.setCaretPosition(0);

            //apply colors to minimum and maximum lap times
            if (lapNumber < 3) {
                MyStopwatch.lapDetails.setText(lastLapValues_2);

                System.out.println("<3    :::  lapno " + lapNumber + " : maxno " + max_lapNumber + " : minno " + min_lapNumber + " : lapgapno " + lapNumberGap);
            } else {
                if (max_lapNumber > min_lapNumber) {
                    lapNumberGap = lapNumber - max_lapNumber;
                    colorCharacter(lapNumberGap * lLV_1_lenght, lLV_1_lenght, "RED", Color.red);

                    lapNumberGap = lapNumber - min_lapNumber;
                    colorCharacter(lapNumberGap * lLV_1_lenght, lLV_1_lenght, "Blue", Color.blue);
                    System.out.println("first block :::  lapno " + lapNumber + " : maxno " + max_lapNumber + " : minno " + min_lapNumber + " : lapgapno " + lapNumberGap);
                }
                if (max_lapNumber < min_lapNumber) {
                    lapNumberGap = lapNumber - min_lapNumber;
                    colorCharacter(lapNumberGap * lLV_1_lenght, lLV_1_lenght, "Blue", Color.blue);

                    lapNumberGap = lapNumber - max_lapNumber;
                    colorCharacter(lapNumberGap * lLV_1_lenght, lLV_1_lenght, "RED", Color.red);
                    System.out.println("second block :::  lapno " + lapNumber + " : maxno " + max_lapNumber + " : minno " + min_lapNumber + " : lapgapno " + lapNumberGap);
                }
            }

        } else {
            gridStore = lastLapValues_1 + "\n" + gridStore;
            System.out.println(gridStore);
        }
        
        lapNumberGap = 0;
            
        lastLapValues_1 = "";
        lastLapValues_2 = "";
    }

    static void colorCharacter(int startCharacter, int stringLength, String colorName, Color fg) {
        Style addStyle = MyStopwatch.lapDetails.addStyle(colorName, null);
        StyleConstants.setForeground(addStyle, fg);
        doc.setCharacterAttributes(startCharacter, stringLength, MyStopwatch.lapDetails.getStyle(colorName), true);
    }

    static void min_maxCalculation() {

        int arrayIndexNum = lapNumber - 1;
        if (lapNumber == 1) {
            lap_List.add(arrayIndexNum, mainTimeCounter.min_max_lapTime);
        } else {
            lap_List.add(arrayIndexNum, lapTimeCounter.min_max_lapTime);

            //find min and max lap times and lap number
            min_lapValue = Collections.min(lap_List);
            min_lapNumber = lap_List.indexOf(min_lapValue) + 1;

            max_lapValue = Collections.max(lap_List);
            max_lapNumber = lap_List.indexOf(max_lapValue) + 1;
        }

    }

    static void gridStore() {
        gridStore = MyStopwatch.lapDetails.getText();
    }

    static void colorLines() {
        System.out.println("max : " + max_lapNumber + " min : " + min_lapNumber + " llv : " + lLV_1_lenght);
        colorCharacter(max_lapNumber * lLV_1_lenght, lLV_1_lenght, "RED", Color.red);
        colorCharacter(min_lapNumber * lLV_1_lenght, lLV_1_lenght, "Blue", Color.blue);
    }
}
