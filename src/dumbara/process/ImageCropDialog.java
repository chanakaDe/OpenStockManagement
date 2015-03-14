/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbara.process;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import dumbara.view.AddEmployee;

/**
 *
 * @author chanu1993
 */
public class ImageCropDialog extends javax.swing.JDialog implements MouseListener, MouseMotionListener {

    /**
     * Creates new form ImageCropDialog
     */
    private Point startPoint, endPoint;
    private AddEmployee parent;
    private int imageWidth, imageHeight;
    private boolean isDragged = false;

    public ImageCropDialog(AddEmployee main, ImageIcon imageIcon, int w, int h, boolean modal) {
        super((JFrame) main, modal);
        parent = main;
        //imageWidth = w;
        //imageHeight = h;
        imageWidth = imageIcon.getIconWidth();
        imageHeight = imageIcon.getIconHeight();
        initComponents();
        double width = 500;
        double ratio = imageWidth / width;
        double calculatedHeight = imageHeight / ratio;

        ImagePanel imagePanel = new ImagePanel(imageIcon,(int)width , (int)calculatedHeight, this);
        add(imagePanel);

        setSize((int)width, (int) calculatedHeight);

        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 689, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 452, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImageCropDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageCropDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageCropDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageCropDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isDragged) {
            endPoint = e.getPoint();
            repaint();
            isDragged = false;
            try {
                cropImage();
            } catch (    AWTException | IOException ex) {
                Logger.getLogger(ImageCropDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void cropImage() throws AWTException, IOException {
        Robot robot = new Robot();

        int x1 = startPoint.x;
        int x2 = endPoint.x;
        int y1 = startPoint.y;
        int y2 = endPoint.y;
        if (x1 == x2 || y1 == y2) {
            JOptionPane.showMessageDialog((Container) parent, "Please draw a rectangle to crop..");
            return;
        }
        int width = x2 - x1;
        int height = y2 - y1;
        height = (height < 0) ? -height : height;
        width = (width < 0) ? -width : width;

        int startx = (x1 < x2) ? x1 : x2;
        int starty = (y1 < y2) ? y1 : y2;

        Point p = this.getLocation();

        Rectangle rectangle = new Rectangle(startx + p.x, starty + p.y, width, height);
        double w = width;
        double ratio = imageWidth / w;
        double calculatedHeight = height * ratio;
        BufferedImage image = robot.createScreenCapture(rectangle);
        ImageIO.write(image, "JPG", new File("./A.JPG"));
        ImageIcon imageIcon = new ImageIcon(image);
        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(imageWidth, (int) calculatedHeight, BufferedImage.SCALE_SMOOTH));

        parent.setImg(imageIcon);

        int res = JOptionPane.showConfirmDialog((Component) parent, "Do you confirm the sub image ?");
        if (res == 0) {
            this.dispose();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (startPoint == null || endPoint == null) {
            return;
        }
        int x1 = startPoint.x;
        int x2 = endPoint.x;
        int y1 = startPoint.y;
        int y2 = endPoint.y;
        int width = x2 - x1;
        int height = y2 - y1;
        height = (height < 0) ? -height : height;
        width = (width < 0) ? -width : width;
        int startx = (x1 < x2) ? x1 : x2;
        int starty = (y1 < y2) ? y1 : y2;
        g.drawRect(startx, starty, width, height);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        isDragged = true;
        endPoint = e.getPoint();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}