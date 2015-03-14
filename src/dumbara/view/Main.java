/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbara.view;

import dumabara.controller.BackupNRestore;
import dumabara.controller.JRibbonController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.common.JCommandMenuButton;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.RibbonTask;
import org.pushingpixels.substance.api.skin.SubstanceOfficeBlack2007LookAndFeel;

/**
 *
 * @author thisara
 */
public class Main extends javax.swing.JFrame {
    private int x;
    /**
     * Creates new form Main
     */
    private Sales salesUI;
    private  long xcx;

   
    public Main() {

        initComponents();

        salesUI = new Sales();

        jpMain.add(salesUI.getContentPane());
  
        JCommandMenuButton jcmEmpUpdate = new JCommandMenuButton("View Employee", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmEmpUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee().setVisible(true);
            }
        });
        
        JCommandMenuButton jcmEmpSearch = new JCommandMenuButton("Search And Update", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmEmpSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchEmployee().setVisible(true);
            }
        });
        
        JCommandMenuButton jcmAgencyView = new JCommandMenuButton("View Agency", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmAgencyView.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAgency().setVisible(true);
            }
        });
        //Customer
        JCommandMenuButton jcmCustomerAdd = new JCommandMenuButton("New Customer", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        JCommandMenuButton jcmAddSupplier = new JCommandMenuButton("Add Supplier", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmAddSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddSupplier().setVisible(true);
            }
        });
        
        JCommandMenuButton jcmLoanOptions = new JCommandMenuButton("Loan Options", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmLoanOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new LoanOptions(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandMenuButton jcmViewAttendence = new JCommandMenuButton("View Attendence", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmViewAttendence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new ViewAttendenceDialog(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandMenuButton jcmAddCustomer = new JCommandMenuButton("Add Customer", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmAddCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new NewCustomerDialog(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandButton btEmployee = JRibbonController.createButtonWithPopup("Employee", JRibbonController.getResizableIconFromResource("icon/emp1.png"), jcmEmpUpdate, jcmEmpSearch);
        btEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddEmployee().setVisible(true);
            }
        });
        JCommandButton btCustomer = JRibbonController.createButtonWithPopup("Sales", JRibbonController.getResizableIconFromResource("icon/graph-icon.png"),jcmCustomerAdd);//big buttons 3
        JCommandButton btAgency = JRibbonController.createButtonWithPopup("Agency", JRibbonController.getResizableIconFromResource("icon/agecy1.png"),jcmAgencyView);//big buttons 3
        btAgency.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new PlaceOrderAgency().setVisible(true);
            }
        });
        
        JCommandButton btSupplier = JRibbonController.createButtonWithPopup("Supplier", JRibbonController.getResizableIconFromResource("icon/supplier1.png"), jcmAddSupplier);
        btSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddSupplierOrder().setVisible(true);
            }
        });
        
        JCommandButton btGRN = JRibbonController.createButton(" GRN  ", JRibbonController.getResizableIconFromResource("icon/GoRN.png"), null);
        btGRN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new NewGRN(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandButton btLoan = JRibbonController.createButtonWithPopup(" Loans  ", JRibbonController.getResizableIconFromResource("icon/loan.png"), jcmLoanOptions);
        btLoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new New_Loan().setVisible(true);
            }
        });
        
        JCommandButton btAttendence = JRibbonController.createButtonWithPopup(" Attendence  ", JRibbonController.getResizableIconFromResource("icon/atten1.png"), jcmViewAttendence);
        btAttendence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddAttendenceDialog(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandButton btCustomer1 = JRibbonController.createButtonWithPopup(" Customer  ", JRibbonController.getResizableIconFromResource("icon/cus.png"), jcmAddCustomer);
        btCustomer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new viewCustomer().setVisible(true);
            }
        });
        
        JCommandButton btInventory = JRibbonController.createButton(" Inventory  ", JRibbonController.getResizableIconFromResource("icon/inven.png"),null);
        btInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddInventory().setVisible(true);
            }
        });
        
        JCommandButton btBackup = JRibbonController.createButton(" Backup  ", JRibbonController.getResizableIconFromResource("icon/backup.png"),null);
        btBackup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int op = fc.showSaveDialog(salesUI);
                if (op == JFileChooser.APPROVE_OPTION) {
                    String path=(fc.getSelectedFile().getPath() + "_" + new Date().getTime() + ".sql");
                    BackupNRestore.backUp(path);
                }
            }
        });
        
        JCommandButton btRestore = JRibbonController.createButton(" Restore  ", JRibbonController.getResizableIconFromResource("icon/restore.png"),null);
        btRestore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JFileChooser jfc = new JFileChooser();
//                int op = jfc.showOpenDialog(salesUI);
//
//                if (op == JFileChooser.APPROVE_OPTION) {
                    try {
                        //String path=(jfc.getSelectedFile().getPath());
                        String path="./wow_1401204134886.sql";
                        BackupNRestore.restoreBackup("dumbara", "root", "chanaka", path);
                    } catch (IOException | InterruptedException ex) {
                        Logger.getLogger(BackupAndRestore.class.getName()).log(Level.SEVERE, null, ex);
                    }

               // }
            }
        });
        
        JCommandButton btNewUser = JRibbonController.createButton("New User", JRibbonController.getResizableIconFromResource("icon/grn.png"),null);
        btNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddNewUser().setVisible(true);
            }
        });
        
        JCommandButton btSMS = JRibbonController.createButton(" Send SMS  ", JRibbonController.getResizableIconFromResource("icon/grn.png"),null);
        btSMS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new SendSMS(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JRibbonBand bandEmployee = JRibbonController.createRibbonBand("Employee", null, btEmployee);
        JRibbonBand bandCustomer = JRibbonController.createRibbonBand("Sales", null, btCustomer);//black band 2
        JRibbonBand bandAgency = JRibbonController.createRibbonBand("Agency", null, btAgency);//black band 2
        JRibbonBand bandSupplier = JRibbonController.createRibbonBand("Supplier", null, btSupplier);
        JRibbonBand bandGRN = JRibbonController.createRibbonBand("GRN", null, btGRN);
        JRibbonBand bandLoan = JRibbonController.createRibbonBand("Loans", null, btLoan);
        JRibbonBand bandAttendence = JRibbonController.createRibbonBand("Attendence", null, btAttendence);
        JRibbonBand bandCustomer1 = JRibbonController.createRibbonBand("Customer", null, btCustomer1);
        JRibbonBand bandInventory = JRibbonController.createRibbonBand("Inventory", null, btInventory);
        JRibbonBand bandBackup = JRibbonController.createRibbonBand("Backup", null, btBackup);
        JRibbonBand bandRestore = JRibbonController.createRibbonBand("Restore", null, btRestore);
        JRibbonBand bandNewUser = JRibbonController.createRibbonBand("NewUser", null, btNewUser);
        JRibbonBand bandSMS = JRibbonController.createRibbonBand("Send SMS", null, btSMS);
       
        RibbonTask taskCustomer;//tabs 1
        taskCustomer = new RibbonTask("Home", bandCustomer,bandAgency,bandSupplier,bandEmployee,bandLoan,
        bandAttendence,bandCustomer1,bandGRN,bandInventory);

        RibbonTask taskOptions=new RibbonTask("Backup & Restore", bandBackup,bandRestore);
        
        //RibbonTask taskOptions1=new RibbonTask("Options", bandNewUser,bandSMS);
        
        ribbon.addTask(taskCustomer);
        ribbon.addTask(taskOptions);
        //ribbon.addTask(taskOptions1);
        
        ribbon.setActionMap(null);

        setSize(1250, 760);
        setResizable(false);
        
    }

/////////////////////other////////////////////////
    public Main(int i) {
        xcx = System.currentTimeMillis();
        initComponents();
        setTitle("Dumbara Water Management System");
        salesUI = new Sales();

        jpMain.add(salesUI.getContentPane());
  
        
         
        
        JCommandMenuButton jcmEmpUpdate = new JCommandMenuButton("View Employee", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmEmpUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee().setVisible(true);
            }
        });
        
        JCommandMenuButton jcmEmpSearch = new JCommandMenuButton("Search And Update", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmEmpSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchEmployee().setVisible(true);
            }
        });
        
        JCommandMenuButton jcmAgencyView = new JCommandMenuButton("View Agency", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmAgencyView.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAgency().setVisible(true);
            }
        });
        //Customer
        JCommandMenuButton jcmCustomerAdd = new JCommandMenuButton("New Customer", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        JCommandMenuButton jcmAddSupplier = new JCommandMenuButton("Add Supplier", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmAddSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddSupplier().setVisible(true);
            }
        });
        
        JCommandMenuButton jcmLoanOptions = new JCommandMenuButton("Set Interest Rate", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmLoanOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new LoanOptions(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandMenuButton jcmLoanOptions1 = new JCommandMenuButton("Set Loan Count", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmLoanOptions1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new LoanOptions1(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandMenuButton jcmViewAttendence = new JCommandMenuButton("View Attendence", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmViewAttendence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new ViewAttendenceDialog(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandMenuButton jcmAddCustomer = new JCommandMenuButton("Add Customer", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmAddCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new NewCustomerDialog(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandMenuButton jcmRestore = new JCommandMenuButton("Restore", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jcmRestore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                int op = jfc.showOpenDialog(salesUI);

                if (op == JFileChooser.APPROVE_OPTION) {
                    try {
                        String path = (jfc.getSelectedFile().getPath());
                        BackupNRestore.restoreEncryptedBackup(path);
                    } catch (IOException | InterruptedException ex) {
                        Logger.getLogger(BackupAndRestore.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
        
        JCommandButton btEmployee = JRibbonController.createButtonWithPopup("Employee", JRibbonController.getResizableIconFromResource("icon/emp1.png"), jcmEmpUpdate, jcmEmpSearch);
        btEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddEmployee().setVisible(true);
            }
        });
        JCommandButton btCustomer = JRibbonController.createButtonWithPopup("Sales", JRibbonController.getResizableIconFromResource("icon/graph-icon.png"),jcmCustomerAdd);//big buttons 3
        JCommandButton btAgency = JRibbonController.createButtonWithPopup("Agency", JRibbonController.getResizableIconFromResource("icon/agecy1.png"),jcmAgencyView);//big buttons 3
        btAgency.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new PlaceOrderAgency().setVisible(true);
            }
        });
        
        JCommandButton btSupplier = JRibbonController.createButtonWithPopup("Supplier", JRibbonController.getResizableIconFromResource("icon/supplier1.png"), jcmAddSupplier);
        btSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddSupplierOrder().setVisible(true);
            }
        });
        
        JCommandButton btGRN = JRibbonController.createButton(" GRN  ", JRibbonController.getResizableIconFromResource("icon/GoRN.png"), null);
        btGRN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new NewGRN(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandButton btLoan = JRibbonController.createButtonWithPopup(" Loans  ", JRibbonController.getResizableIconFromResource("icon/loan.png"), jcmLoanOptions,jcmLoanOptions1);
        btLoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new New_Loan().setVisible(true);
            }
        });
        
        JCommandButton btAttendence = JRibbonController.createButtonWithPopup(" Attendence  ", JRibbonController.getResizableIconFromResource("icon/atten1.png"), jcmViewAttendence);
        btAttendence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddAttendenceDialog(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandButton btCustomer1 = JRibbonController.createButtonWithPopup(" Customer  ", JRibbonController.getResizableIconFromResource("icon/cus.png"), jcmAddCustomer);
        btCustomer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new viewCustomer().setVisible(true);
            }
        });
        
        JCommandButton btInventory = JRibbonController.createButton(" Inventory  ", JRibbonController.getResizableIconFromResource("icon/inven.png"),null);
        btInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddInventory().setVisible(true);
            }
        });
        
        JCommandButton btBackup = JRibbonController.createButtonWithPopup(" Backup  ", JRibbonController.getResizableIconFromResource("icon/backup.png"),jcmRestore);
        btBackup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int op = fc.showSaveDialog(salesUI);
                if (op == JFileChooser.APPROVE_OPTION) {
                    String path=(fc.getSelectedFile().getPath() + "_" + new Date().getTime() + ".sql");
                    BackupNRestore.backUpEncrypt(path);
                }
            }
        });
        
        /////Add Options
        JCommandMenuButton jccNewUser = new JCommandMenuButton("New User", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jccNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddNewUser().setVisible(true);
            }
        });
        
        JCommandMenuButton jccChangeUserDetail = new JCommandMenuButton("User Control", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jccChangeUserDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new ChangeUserDetails(salesUI, rootPaneCheckingEnabled, null).setVisible(true);
            }
        });
        
        JCommandMenuButton jccAddAnswers = new JCommandMenuButton("Optional anwsers", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jccAddAnswers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddAnswers(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandMenuButton jccAddQustions = new JCommandMenuButton("Optional Questions", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jccAddQustions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new LoginSystemDialog(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandMenuButton jccEmail = new JCommandMenuButton("Email Config", JRibbonController.getResizableIconFromResource("icon/Windows 6.png"));
        jccEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new EmailConfig(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JCommandButton btOptions = JRibbonController.createButtonWithPopup(" Options  ", JRibbonController.getResizableIconFromResource("icon/restore.png"),jccNewUser,jccChangeUserDetail,jccAddAnswers,jccAddQustions,jccEmail);
        btOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        JCommandButton btNewUser = JRibbonController.createButton("New User", JRibbonController.getResizableIconFromResource("icon/grn.png"),null);
        btNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AddNewUser().setVisible(true);
            }
        });
        
        JCommandButton btSMS = JRibbonController.createButton(" Send SMS  ", JRibbonController.getResizableIconFromResource("icon/grn.png"),null);
        btSMS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new SendSMS(salesUI, rootPaneCheckingEnabled).setVisible(true);
            }
        });
        
        JRibbonBand bandEmployee = JRibbonController.createRibbonBand("Employee", null, btEmployee);
        JRibbonBand bandCustomer = JRibbonController.createRibbonBand("Sales", null, btCustomer);//black band 2
        JRibbonBand bandAgency = JRibbonController.createRibbonBand("Agency", null, btAgency);//black band 2
        JRibbonBand bandSupplier = JRibbonController.createRibbonBand("Supplier", null, btSupplier);
        JRibbonBand bandGRN = JRibbonController.createRibbonBand("GRN", null, btGRN);
        JRibbonBand bandLoan = JRibbonController.createRibbonBand("Loans", null, btLoan);
        JRibbonBand bandAttendence = JRibbonController.createRibbonBand("Attendence", null, btAttendence);
        JRibbonBand bandCustomer1 = JRibbonController.createRibbonBand("Customer", null, btCustomer1);
        JRibbonBand bandInventory = JRibbonController.createRibbonBand("Inventory", null, btInventory);
        JRibbonBand bandBackup = JRibbonController.createRibbonBand("Backup", null, btBackup);
        JRibbonBand bandOptions = JRibbonController.createRibbonBand("Options", null, btOptions);
        JRibbonBand bandNewUser = JRibbonController.createRibbonBand("NewUser", null, btNewUser);
        JRibbonBand bandSMS = JRibbonController.createRibbonBand("Send SMS", null, btSMS);
       
        RibbonTask taskCustomer;//tabs 1
        taskCustomer = new RibbonTask("Home", bandCustomer,bandAgency,bandSupplier,bandEmployee,bandLoan,
        bandAttendence,bandCustomer1,bandGRN,bandInventory);

        RibbonTask taskOptions=new RibbonTask("Configurations", bandBackup,bandOptions);
        
        //RibbonTask taskSettings=new RibbonTask("Settings", bandNewUser,bandSMS);
        
        ribbon.addTask(taskCustomer);
        ribbon.addTask(taskOptions);
        //ribbon.addTask(taskSettings);
        
        ribbon.setActionMap(null);

        setSize(1250, 760);
        setResizable(false);

        if(i==1){           ///3 times
            Sales.graphsPanel.setEnabled(false);
            Sales.jButton8.setEnabled(false);
            Sales.jButton7.setEnabled(false);
            Sales.removeButton.setEnabled(false);
            Sales.submitButton.setEnabled(false);
            //
            btAgency.setEnabled(false);
            btSupplier.setEnabled(false);
            btAttendence.setEnabled(false);
            btLoan.setEnabled(false);
            btBackup.setEnabled(false);
            btOptions.setEnabled(false);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ribbon = new org.pushingpixels.flamingo.api.ribbon.JRibbon();
        jpMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jpMain.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ribbon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ribbon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        xcx = System.currentTimeMillis();
    }//GEN-LAST:event_formMouseMoved

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int showConfirmDialog = JOptionPane.showConfirmDialog(rootPane, "Do you need to create a backup ?", "Warning !", JOptionPane.YES_NO_OPTION);
        if (showConfirmDialog==JOptionPane.YES_OPTION) {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int op = fc.showSaveDialog(salesUI);
            if (op == JFileChooser.APPROVE_OPTION) {
                String path = (fc.getSelectedFile().getPath() + "_" + new Date().getTime() + ".sql");
                BackupNRestore.backUpEncrypt(path);
            }
        }else{
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SubstanceOfficeBlack2007LookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

                Main main = new Main();
                main.setExtendedState(JFrame.MAXIMIZED_BOTH | main.getExtendedState());
                main.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpMain;
    private org.pushingpixels.flamingo.api.ribbon.JRibbon ribbon;
    // End of variables declaration//GEN-END:variables


}
