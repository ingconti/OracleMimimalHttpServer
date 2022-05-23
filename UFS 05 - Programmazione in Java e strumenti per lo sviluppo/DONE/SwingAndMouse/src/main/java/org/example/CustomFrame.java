package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

public class CustomFrame extends JFrame implements MouseListener {


    public CustomFrame() {
        addMouseListener(this);
    }

    public void paint(Graphics g) {

        super.paint(g); // always call this first - BUT MAY flicker.. on repaint..

        //g.drawString("Hello", 200, 50);

        int rectwidth = 150;
        int rectheight = 150;

        //was: g.drawRect(x, y, rectwidth, rectheight);
        if (p!=null)
            g.drawOval(p.x-rectwidth/2,
                    p.y - rectheight/2,
                    rectwidth, rectheight);
    }

    private Point p;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("x " + e.getX() + ", y: " + e.getY());
        this.p = e.getPoint();
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
