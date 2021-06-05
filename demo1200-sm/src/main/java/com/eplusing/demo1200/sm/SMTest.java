package com.eplusing.demo1200.sm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.commons.codec.binary.Base64;

public class SMTest {
    public static void main(String[] args) throws Exception {

        //SM4秘钥
        String sm4Key = "6836FF8AE774DDE4469CA3191EADBC4F";

   /*     byte[] buffer = null;
        try
        {
            FileInputStream fis = new FileInputStream(new File("D:\\Share\\重构\\支付网关\\开放支付网关-20201118.docx"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("读入明文文件D:\\Share\\重构\\支付网关\\开放支付网关-20201118.docx");

        String enStr = SM4.encryptBase64Str(buffer, hexStringToBytes(sm4Key), "GBK");
        int len = enStr.length();
        int offset = 190000;

        int num = len / offset;

        for(int i = 0; i < num +1; i++) {
            if(i == num) {
                String tempEnStr = enStr.substring(i * offset);
                ByteBuffer bb1 = ByteBuffer.wrap(tempEnStr.getBytes("GBK"));

                FileChannel fc1 = new FileOutputStream("D:\\Users\\caopengpeng762\\Desktop\\blog\\temp.base64EncodeSec" + i).getChannel();
                fc1.write(bb1);
                fc1.close();

            }else {
                String tempEnStr = enStr.substring(i * offset, i * offset + offset);
                ByteBuffer bb1 = ByteBuffer.wrap(tempEnStr.getBytes("GBK"));

                FileChannel fc1 = new FileOutputStream("D:\\Users\\caopengpeng762\\Desktop\\blog\\temp.base64EncodeSec" + i).getChannel();
                fc1.write(bb1);
                fc1.close();
            }

            System.out.println("加密为D:\\Users\\caopengpeng762\\Desktop\\blog\\temp.base64EncodeSec"  + i);

        }
*/


        byte[] buffer1 = null;
        try {
            ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
            FileInputStream fis1 = null;
            int num = 0;

            for (int i = 0; i < num + 1; i++) {

                fis1 = new FileInputStream(new File("C:\\Users\\Admin\\Desktop\\logs\\patms-pay-gw-inner.base64EncodeSec" + i));
                byte[] b = new byte[1024 * 1024];
                int n;
                while ((n = fis1.read(b)) != -1) {
                    bos1.write(b, 0, n);
                }
                fis1.close();
                System.out.println("读入加密文件C:\\Users\\Admin\\Desktop\\logs\\patms-pay-gw-inner." + i);
            }

            bos1.close();
            buffer1 = bos1.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String enStr = new String(buffer1);


        byte[] deBytes = SM4.decryptBase64(Base64.decodeBase64(enStr), hexStringToBytes(sm4Key));

        //byte[] bs= s.getBytes();

        ByteBuffer bb = ByteBuffer.wrap(deBytes);

        FileChannel fc = new FileOutputStream("C:\\Users\\Admin\\Desktop\\logs\\patms-pay-gw-inner.7z").getChannel();
        fc.write(bb);
        fc.close();
        System.out.println("解密加密文件C:\\Users\\Admin\\Desktop\\logs\\patms-pay-gw-inner.7z");



    }


    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }

        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    public static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

}
