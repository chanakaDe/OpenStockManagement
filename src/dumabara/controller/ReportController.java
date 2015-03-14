/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;

import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ChanakaDe
 */
public class ReportController {

    public static void viewReport(Map<String, Object> mp, String dest) throws JRException {
        JasperReport jr = JasperCompileManager.compileReport(dest);
        JasperPrint jp = JasperFillManager.fillReport(jr, mp);
        JasperViewer.viewReport(jp, false);

    }

    public static void viewReport(Map<String, Object> mp, String dest, JRDataSource ds) throws JRException {
        JasperReport jr = JasperCompileManager.compileReport(dest);
        JasperPrint jp = JasperFillManager.fillReport(jr, mp, ds);
        JasperViewer.viewReport(jp, false);

    }

    public static void viewReport(Map<String, Object> mp, String dest, Connection con) throws JRException {
        JasperReport jr = JasperCompileManager.compileReport(dest);
        JasperPrint jp = JasperFillManager.fillReport(jr, mp, con);
        JasperViewer.viewReport(jp, false);

    }

}
