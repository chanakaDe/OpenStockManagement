/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author chanakaDe
 */
public class FileEncryptor {
    private String algo;
    private File file;
    private String path;

    public FileEncryptor(String algo, String path) {
        this.algo = algo; //setting algo
        this.file = new File(path); //settong file
        this.path=path;
    }
    public void encrypt() throws Exception {
        //opening streams
        FileInputStream fis = new FileInputStream(file);
        file = new File(file.getAbsolutePath() + ".enc");
        //file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        //generating key
        byte k[] = "HignDlPs".getBytes();
        SecretKeySpec key = new SecretKeySpec(k, algo.split("/")[0]);
        //creating and initialising cipher and cipher streams
        Cipher encrypt = Cipher.getInstance(algo);
        encrypt.init(Cipher.ENCRYPT_MODE, key);
        CipherOutputStream cout = new CipherOutputStream(fos, encrypt);

        byte[] buf = new byte[1024];
        int read;
        while ((read = fis.read(buf)) != -1) //reading data
        {
            cout.write(buf, 0, read);  //writing encrypted data
        }         //closing streams
        fis.close();
        cout.flush();
        cout.close();
        File file12=new File(path);
        file12.delete();
    }

    public void decrypt() throws Exception {
        //opening streams
        FileInputStream fis = new FileInputStream(file);
        file = new File(file.getAbsolutePath() + ".dec");
        FileOutputStream fos = new FileOutputStream(file);
        //generating same key
        byte k[] = "HignDlPs".getBytes();
        SecretKeySpec key = new SecretKeySpec(k, algo.split("/")[0]);
        //creating and initialising cipher and cipher streams
        Cipher decrypt = Cipher.getInstance(algo);
        decrypt.init(Cipher.DECRYPT_MODE, key);
        CipherInputStream cin = new CipherInputStream(fis, decrypt);

        byte[] buf = new byte[1024];
        int read = 0;
        while ((read = cin.read(buf)) != -1) //reading encrypted data
        {
            fos.write(buf, 0, read);  //writing decrypted data
        }         //closing streams
        cin.close();
        fos.flush();
        fos.close();
        System.out.println(file.getName());
//        if(file.getName().equals("Backup.sql")){
//            System.out.println(file.getAbsolutePath());
//        file.delete();
//        }
    }
}


