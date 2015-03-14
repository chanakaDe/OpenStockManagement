/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbara.view;

import dumabara.controller.LoanController;
import dumabara.controller.LoanSettleController;
import dumabara.controller.SalesController;
import dumbara.model.Chart;
import dumbara.model.Chart3;
import dumbara.model.Chart4;
import dumbara.model.Loan;
import dumbara.model.LoanSettle;
import dumbara.model.Sale;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author chanu1993
 */
public class Chart1 {
    public static void byIncome(){
         DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        try {
            Sale[] sale = SalesController.viewAllSales();
            for (Sale sale1 : sale) {
                objDataset.setValue(sale1.getIncome(), "Sales Progress", sale1.getSalesID());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Chart1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();       
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyyy.MM.dd");
        String format = simpleDateFormat.format(result);
        Date date=new Date();
        String format1 = simpleDateFormat.format(date);
        
        JFreeChart objChart = ChartFactory.createBarChart(
                "Sales Comparisson by Sales ID from "+format+" to "+format1,
                "Sales ID",
                "Sales Income",
                objDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
                
                
                
        );
        ChartFrame frame = new ChartFrame("Data Analysis Wizard - v2.1.4", objChart);
        frame.pack();
        frame.setSize(1300, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public static void byAgent() {
        DefaultPieDataset objDataset = new DefaultPieDataset();
        try {
            Chart[] charts = SalesController.getAgencyAmounts();
            for (Chart chart : charts) {
                objDataset.setValue(chart.getAgencyID(), chart.getIncomeSum());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Chart1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();       
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyyy.MM.dd");
        String format = simpleDateFormat.format(result);
        Date date=new Date();
        String format1 = simpleDateFormat.format(date);
        
        JFreeChart objChart = ChartFactory.createPieChart(
                "Sales Range of Agencies from "+format+" to "+format1,
                objDataset,
                true,
                true,
                false);
        ChartFrame frame = new ChartFrame("Data Analysis Wizard - v2.1.4", objChart);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    
    public static void loanInfo(){
        DefaultPieDataset objDataset = new DefaultPieDataset();
        try {
             Loan[] loan=LoanController.viewLoan();
             for (Loan loan1 : loan) {
                objDataset.setValue(loan1.getLoanID() , Double.parseDouble(loan1.getLongAmount()) );
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Chart1.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFreeChart objChart = ChartFactory.createPieChart(
                "Variation of Loan Amounts",
                objDataset,
                true, 
                true, 
                false 
        );
        ChartFrame frame = new ChartFrame("Data Analysis Wizard - v2.1.4", objChart);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    public static void byEmployee(){
         DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        try {
             dumbara.model.Chart1[] chart1=LoanController.getLoanAmounts();
             for (dumbara.model.Chart1 chart11 : chart1) {
                objDataset.setValue(chart11.getLoanamount(), "Loan amounts", chart11.getEmpID());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Chart1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        JFreeChart objChart = ChartFactory.createBarChart(
                "Total Loan Amounts of Employees",
                "Employee ID",
                "Loan Amount (Rs.)",
                objDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        ChartFrame frame = new ChartFrame("Data Analysis Wizard - v2.1.4", objChart);
        frame.pack();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    public static void paymentHistory(){
         DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        try {
            LoanSettle[] loanSettles=LoanSettleController.viewLoanSettle();
            for (LoanSettle loanSettle : loanSettles) {
                objDataset.setValue(Double.parseDouble(loanSettle.getPayment()) , "Loan Payments", loanSettle.getLoanSettleID());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Chart1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        JFreeChart objChart = ChartFactory.createBarChart(
                "Sales Comparisson",
                "Sales ID",
                "Sales Income",
                objDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        ChartFrame frame = new ChartFrame("Data Analysis Wizard - v2.1.4", objChart);
        frame.pack();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    public static void paymentHistorybyEmp(String empID){
         DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        try {
            LoanSettle[] loanSettles=LoanSettleController.viewLoanSettlebyEmp(empID);
            for (LoanSettle loanSettle : loanSettles) {
                objDataset.setValue(Double.parseDouble(loanSettle.getPayment()) , "Loan Payments", loanSettle.getLoanSettleID());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Chart1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        JFreeChart objChart = ChartFactory.createBarChart(
                "Loan Settlements of Employee No "+empID,
                "Loan Settle ID",
                "Amount (Rs.)",
                objDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        ChartFrame frame = new ChartFrame("Data Analysis Wizard - v2.1.4", objChart);
        frame.pack();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    public static void getBottleIncome(){
         DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        try {
            Chart3[] chart3s=SalesController.getBottleIncome();
            for (Chart3 chart3 : chart3s) {
                objDataset.setValue(chart3.getIncome() , "Bottle Income", chart3.getBottleID());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Chart1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();       
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyyy.MM.dd");
        String format = simpleDateFormat.format(result);
        Date date=new Date();
        String format1 = simpleDateFormat.format(date);
        JFreeChart objChart = ChartFactory.createBarChart(
                "Sales Comparisson by Bottle ID from "+format+" to "+format1,
                "Bottle ID",
                "Sales Income",
                objDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        ChartFrame frame = new ChartFrame("Data Analysis Wizard - v2.1.4", objChart);
        frame.pack();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    public static void getIncomebyDate(){
         DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        try {
            Chart4[] chart4s=SalesController.getIncomeByDate();
            for (Chart4 chart4 : chart4s) {
                objDataset.setValue(chart4.getSumIncme() , "Days Income", chart4.getSalesDate());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Chart1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        JFreeChart objChart = ChartFactory.createBarChart(
                "Total Sales Comparisson by Date",
                "Sales Date",
                "Sales Income",
                objDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        ChartFrame frame = new ChartFrame("Data Analysis Wizard - v2.1.4", objChart);
        frame.pack();
        frame.setSize(1100, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    //x=months,  y = income
     public static void ViewLineChart(String[] agencyID , String[] sslesDate , ArrayList<String[]> arrayList ) throws SQLException, ClassNotFoundException {
         XYSeries series1 = new XYSeries("Agency 1");
         XYSeries series2 = new XYSeries("Agency 2");
         XYSeries series3 = new XYSeries("Agency 3");
         XYSeries series4 = new XYSeries("Agency 4");
        
         for (String[] strings : arrayList) {


             for (int i = 0; i < sslesDate.length; i++) {
                 System.out.println(sslesDate[i].split("-")[1]+"");
                 series1.add(Double.parseDouble(sslesDate[i].split("-")[1]+""), Double.parseDouble(arrayList.get(0)[i]));
             }


             for (int i = 0; i < sslesDate.length; i++) {
                 series2.add(Double.parseDouble(sslesDate[i].split("-")[1]+""), Double.parseDouble(arrayList.get(1)[i]));
             }


             for (int i = 0; i < sslesDate.length; i++) {
                 series3.add(Double.parseDouble(sslesDate[i].split("-")[1]+""), Double.parseDouble(arrayList.get(2)[i]));
             }


             for (int i = 0; i < sslesDate.length; i++) {
                 series4.add(Double.parseDouble(sslesDate[i].split("-")[1]+""), Double.parseDouble(arrayList.get(3)[i]));
                 
             }


         }
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        XYDataset dataset1 = dataset;
        JFreeChart chart = ChartFactory.createXYLineChart(
                "",
                "Test Id",
                "Average Marks",
                dataset1,
                PlotOrientation.VERTICAL,
                true,
                false,
                false);
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesLinesVisible(2, true);
        renderer.setSeriesShapesVisible(2, true);
        renderer.setSeriesFillPaint(2, Color.MAGENTA);
        plot.setRenderer(renderer);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
        //(chartPanel);
        ChartFrame frame = new ChartFrame("Dumbara Water Management System", chart);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    public class LineChartSample extends Application {

        @Override
        public void start(Stage stage) {
            stage.setTitle("Line Chart Sample");
            //defining the axes
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Number of Month");
            //creating the chart
            final LineChart<Number, Number> lineChart =
                    new LineChart<Number, Number>(xAxis, yAxis);

            lineChart.setTitle("Stock Monitoring, 2010");
            //defining a series
            XYChart.Series series = new XYChart.Series();
            series.setName("My portfolio");
            //populating the series with data
            series.getData().add(new XYChart.Data(1, 23));
            series.getData().add(new XYChart.Data(2, 14));
            series.getData().add(new XYChart.Data(3, 15));
            series.getData().add(new XYChart.Data(4, 24));
            series.getData().add(new XYChart.Data(5, 34));
            series.getData().add(new XYChart.Data(6, 36));
            series.getData().add(new XYChart.Data(7, 22));
            series.getData().add(new XYChart.Data(8, 45));
            series.getData().add(new XYChart.Data(9, 43));
            series.getData().add(new XYChart.Data(10, 17));
            series.getData().add(new XYChart.Data(11, 29));
            series.getData().add(new XYChart.Data(12, 25));

            Scene scene = new Scene(lineChart, 800, 600);
            lineChart.getData().add(series);

            stage.setScene(scene);
            stage.show();
        }
    }
}


