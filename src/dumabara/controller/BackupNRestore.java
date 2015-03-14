/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ChanakaDe
 */
public class BackupNRestore {

    public static void backUp(String path) {
        
        try {
            String dbName = "Dumbara";
            String dbUser = "root";
            String dbPass = "chanaka";

            String executeCmd = "mysqldump -u " + dbUser + " -p" + dbPass
                    + " --add-drop-database -B " + dbName + " -r " + path;

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup Complete");
                JOptionPane.showMessageDialog(null, "Backup Completed");
            } else {
                System.out.println("Backup Failure");
                JOptionPane.showMessageDialog(null, "Backup Error");
            }

        } catch (IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
        }
    }
    
     public static void restoreBackup(String dbName, String dbUserName, String dbPassword, String path) throws IOException, InterruptedException {

        String[] executeCmd = new String[]{"mysql", "--user=" + dbUserName, "--password=" + dbPassword, dbName, "-e", " source " + path};
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int processComplete = runtimeProcess.waitFor();

        if (processComplete == 0) {
            JOptionPane.showMessageDialog(null, "Database Created....");
        } else {
            JOptionPane.showMessageDialog(null, "Restore Faild");
        }
    }
     
     // Encrypted Controllers.
     public static int backUpEncrypt(String path){
        int processComplete = 0 ;
        
        try {
            String dbName = "dumbara";
            String dbUser = "root";
            String dbPass = "chanaka";

            String executeCmd = "mysqldump -u " + dbUser + " -p" + dbPass
                    + " --add-drop-database -B " + dbName + " -r " + path;

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            processComplete = runtimeProcess.waitFor();
            if (processComplete==0) {
                JOptionPane.showMessageDialog(null, "Backup Completed..");
            }else{
                JOptionPane.showMessageDialog(null, "Error in backup");
            }
            try {
                new FileEncryptor("DES/ECB/PKCS5Padding",path).encrypt();
            } catch (Exception ex) {
                Logger.getLogger(BackupNRestore.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + e.getMessage());
        }
        return processComplete;
    }
     
    public static int restoreEncryptedBackup(String path) throws IOException, InterruptedException{
        String dbName = "dumbara";
        String dbUserName = "root";
        String dbPassword = "chanaka";
        try {
            new FileEncryptor("DES/ECB/PKCS5Padding",path).decrypt();
        } catch (Exception ex) {
            Logger.getLogger(BackupNRestore.class.getName()).log(Level.SEVERE, null, ex);
        }
        String newPath=path+".dec";
        String[] executeCmd = new String[]{"mysql", "--user=" + dbUserName, "--password=" + dbPassword, dbName, "-e", " source " + newPath};

        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        

        int processComplete = runtimeProcess.waitFor();
        if(processComplete==0){
            JOptionPane.showMessageDialog(null, "Restored....");
        File file12=new File(path+".dec");
        file12.delete();
        }else{
            JOptionPane.showMessageDialog(null, "Error in Restoring...");
        }
        return processComplete;
        
    }
     

}




