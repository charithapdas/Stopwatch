/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatch;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author charith_ds
 */
public class FrameDragListener extends MouseAdapter{
    
    //move jFrame after removing the title bar
    
    private final JFrame frame;
    private  Point mouseDownCompCoords = null;
    
    public FrameDragListener(JFrame frame){
        this.frame = frame;
    }
    @Override
    public void mouseReleased(MouseEvent e){
        mouseDownCompCoords = null;
    }
    @Override
    public void mousePressed(MouseEvent e){
        mouseDownCompCoords = e.getPoint();
    }
    @Override
    public void mouseDragged(MouseEvent e){
        Point currCoords = e.getLocationOnScreen();
        frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }
    
}
