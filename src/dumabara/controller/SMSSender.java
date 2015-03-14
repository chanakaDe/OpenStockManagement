package dumabara.controller;

import dumbara.model.SMS;
import java.util.ArrayList;
import java.util.List;
import jssc.SerialPort;
import jssc.SerialPortException;

public class SMSSender {

    /**
     *
     * @author thisara
     */
    public static boolean send(String port, String no, String body) {
        boolean sent = false;
        SerialPort sp = null;        
        try {
            sp = new SerialPort(port);
            System.out.println("Port " + port);
            System.out.println("No " + no);
            System.out.println("Body " + body);
            sp.openPort();
            sp.setParams(9600, 8, 1, 0);
            String s = "AT+CMGF=1";
            writeMsg(sp, s);
            sp.writeInt(13);

            s = "AT+CMGS=\"" + no + "\"";
            writeMsg(sp, s);
            sp.writeInt(13);

            s = body;
            writeMsg(sp, s);
            sp.writeInt(0x1A);
            sp.writeInt(13);

            System.out.println("SMS Sent !!! " + s);
            sent = true;
        } catch (Exception ex) {
            sent = false;
            ex.printStackTrace();
        } finally {
            try {
                sp.closePort();
            } catch (Exception e) {
            }
        }
        return sent;
    }
    
    public static boolean sendAuto(String port, String no, List<SMS> sms) {
        for (SMS sms1 : sms) {
            String id=sms1.getId();
            String qty=sms1.getQty();
            String unitPrice=sms1.getUnitPrice();
            String totalPrice=sms1.getTotalPrice();
        
            String body=id+"\n"+qty+"\n"+unitPrice+"\n"+totalPrice;
            
        boolean sent = false;
        SerialPort sp = null;        
        try {
            sp = new SerialPort(port);
            System.out.println("Port " + port);
            System.out.println("No " + no);
            System.out.println("Body " + body);
            sp.openPort();
            sp.setParams(9600, 8, 1, 0);
            String s = "AT+CMGF=1";
            writeMsg(sp, s);
            sp.writeInt(13);

            s = "AT+CMGS=\"" + no + "\"";
            writeMsg(sp, s);
            sp.writeInt(13);

            s = body;
            writeMsg(sp, s);
            sp.writeInt(0x1A);
            sp.writeInt(13);

            System.out.println("SMS Sent !!! " + s);
            sent = true;
        } catch (Exception ex) {
            sent = false;
            ex.printStackTrace();
        } finally {
            try {
                sp.closePort();
            } catch (Exception e) {
            }
        }
        return sent;
        }
        return false;
    }

    private static void writeMsg(SerialPort sp, String s) throws SerialPortException {
        char ch[] = s.toCharArray();
        for (int j = 0; j < ch.length; j++) {
            sp.writeInt((int) ch[j]);
        }
    }
}
