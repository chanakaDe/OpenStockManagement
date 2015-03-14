/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbara.view;

import dumabara.controller.AgencyController;
import dumabara.controller.SalesController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author ChanakaDe
 */
public class NewClass1 extends JApplet {

    private static final int JFXPANEL_WIDTH_INT = 1000;
    private static final int JFXPANEL_HEIGHT_INT = 650;
    private static JFXPanel fxContainer;
    String[] agencyIDs;
    String[] salesDate;
    String[] income = null;
    ArrayList<String[]> incomeList = new ArrayList<>();
    ArrayList<String[]> dateList = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {


                JFrame frame = new JFrame("Data Analysis Wizard - v2.2.4");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JApplet applet = new NewClass1();
                applet.init();

                frame.setContentPane(applet.getContentPane());

                frame.pack();
                frame.setDefaultCloseOperation(2);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                applet.start();
            }
        });
    }

    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                createScene();
            }
        });
    }

    private void createScene() {

        {
            try {
                agencyIDs = AgencyController.getAgencyID();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LineChartSample1.class.getName()).log(Level.SEVERE, null, ex);
            }


            for (int i = 0; i < agencyIDs.length; i++) {
                try {
                    income = SalesController.getIncome(agencyIDs[i]);
                    salesDate = SalesController.getSalesDate(agencyIDs[i]);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(LineChartSample1.class.getName()).log(Level.SEVERE, null, ex);
                }
                incomeList.add(income);
                dateList.add(salesDate);
            }
        }

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        final LineChart<String, Number> lineChart =
                new LineChart<String, Number>(xAxis, yAxis);

        lineChart.setTitle("Sales Monitoring, 2014");

        XYChart.Series series[] = new XYChart.Series[4];
        System.out.println(agencyIDs.length);

        System.out.println("saleDate " + salesDate.length);
        System.out.println("income" + Arrays.toString(incomeList.get(0)));
        System.out.println("income" + Arrays.toString(incomeList.get(1)));
        System.out.println("income" + Arrays.toString(incomeList.get(2)));
        System.out.println("income" + Arrays.toString(incomeList.get(3)));


        for (int i = 0; i < 4; i++) {
            series[i] = new XYChart.Series();
            series[i].setName(agencyIDs[i]);
            String[] get = incomeList.get(i);
            String[] get1 = dateList.get(i);
            for (int j = 0; j < get1.length; j++) {
                series[i].getData().add(new XYChart.Data(get1[j], Integer.parseInt(get[j])));
            }
        }

        for (int i = 0; i < series.length; i++) {
            lineChart.getData().add(series[i]);
        }
        Scene scene = new Scene(lineChart, 800, 600);
        fxContainer.setScene(scene);
    }
}
