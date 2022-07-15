package com.eplusing.demo1200.leetcode.huawei;

import java.util.Scanner;

public class IpAndYanMa2 {

    private static int a = 0;

    // A类IP

    private static int b = 0;

    // B类IP

    private static int c = 0;

    // C类IP

    private static int d = 0;

    // D类IP

    private static int e = 0;

    // E类IP

    private static int error = 0;

    // 错误IP

    private static int pri = 0;

    // 私有IP

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {

            String s = in.nextLine();

            checkIp(s);

        }

        System.out.println(a + "" + b + " " + c + " " + d + " " + e + "" + error + " " + pri);

        in.close();

    }

    private static void checkIp(String s) {

        String[] str = s.split("~");

        String ip = str[0];

        String mask = str[1];

        String[] ipParts = ip.split("\\.");

        String[] maskParts = mask.split("\\.");

        int[] ipInts = new int[4];

        int[] maskInts = new int[4];

        // 判断IP是否由4部分组成

        if (ipParts.length != 4 || maskParts.length != 4) {

            error++;

            return;

        }

        // 判断IP中的每一部分格式

        // 将IP解析成数字

        for (int i = 0; i < 4; i++) {

            if ("".equals(ipParts[i]) || "".equals(maskParts[i])) {

                error++;

                return;

            }

            try {

                ipInts[i] = Integer.parseInt(ipParts[i]);

                maskInts[i] = Integer.parseInt(maskParts[i]);

            } catch (NumberFormatException e) {

                e.printStackTrace();

            }

            if (ipInts[i] < 0 || maskInts[i] < 0 || ipInts[i] > 255 || maskInts[i] > 255) {

                error++;

                return;

            }

        }

        // 将掩码转成二进制格式

        String maskBinarry = "";

        for (int i = 0; i < maskParts.length; i++) {

            maskBinarry += Integer.toBinaryString(maskInts[i]);

        }

        // 掩码中，最后一个1前如果有0说明掩码不合法

        if (maskBinarry.substring(0, maskBinarry.lastIndexOf("1") + 1).contains("0")) {

            error++;

            return;

        }


        if (ipInts[0] >= 1 && ipInts[0] <= 126) {

            a++;

            if (ipInts[0] == 10) {

                pri++;

            }

        }

        if (ipInts[0] >= 128 && ipInts[0] <= 191) {

            b++;

            if (ipInts[0] == 172) {

                if (ipInts[1] >= 16 && ipInts[1] <= 31) {

                    pri++;

                }

            }

        }

        if (ipInts[0] >= 192 && ipInts[0] <= 223) {

            c++;

            if (ipInts[0] == 192) {

                if (ipInts[1] == 168) {

                    pri++;

                }

            }

        }

        if (ipInts[0] >= 224 && ipInts[0] <= 239) {

            d++;

        }

        if (ipInts[0] >= 240 && ipInts[0] <= 255) {

            e++;

        }

    }

}