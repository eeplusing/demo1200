package com.eplusing.demo1200.base.util;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EmailUtil {

    public static void main(String[] args) {
        MailAccount account = new MailAccount();
        account.setHost("127.0.0.1");
        account.setPort(25251);
        account.setAuth(false);
        account.setFrom("testSend@qq.com");
        List<String> toList = new ArrayList<>();
        toList.add("testtoRecv@qq.com");
        List<String> ccList = new ArrayList<>();
        ccList.add("testCcRecv@qq.com");
        List<String> bcList = new ArrayList<>();
        bcList.add("testBcRecv@qq.com");
        String subject = "MAIL-TEST";
        String body = "<html>test html body</html>";
        MailUtil.send(account, toList, ccList, bcList, subject, body, true);
        File f1 = new File("D:\\opt\\Java\\jdk1.8.0_281\\jmc.txt");
        File f2 = new File("D:\\opt\\Java\\jdk1.8.0_281\\COPYRIGHT");
        File[] files = new File[]{f1, f2};
        MailUtil.send(account, toList, ccList, bcList, subject, body, true, files);


        //TODO 测试发送结束
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
