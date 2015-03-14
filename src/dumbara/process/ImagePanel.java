/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbara.process;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author chanu1993
 */
class ImagePanel extends JPanel {

    private ImageIcon img;
    private JDialog frame;


    public ImagePanel(ImageIcon img,int w,int h, JDialog frame) {
        this.img = img;
        this.frame = frame;
        Dimension size = new Dimension(w,h);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        this.setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img.getImage(), 0, 0, frame.getWidth(), frame.getHeight(), null);
    }
}