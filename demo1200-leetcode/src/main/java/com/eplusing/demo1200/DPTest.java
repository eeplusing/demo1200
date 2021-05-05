package com.eplusing.demo1200;

import java.util.Scanner;

public class DPTest {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();

        long[][] pos = new long[x + 1][y + 1];
        while (0 < n) {
            int bossX = sc.nextInt();
            int bossY = sc.nextInt();
            if (bossX <= x && bossY <= y) {
                pos[bossX][bossY] = -1;
            }
            n--;
        }

        pos[0][0] = 1;

        //首行初始化
        for (int j = 0; j <= y; j++) {
            if (pos[0][j] != -1) {
                pos[0][j] = 1;
            } else {
                break;
            }
        }

        //首列初始化
        for (int i = 0; i <= x; i++) {
            if (pos[i][0] != -1) {
                pos[i][0] = 1;
            } else {
                break;
            }
        }


        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (pos[i][j] == -1) {
                    continue;
                }
                if (pos[i - 1][j] == -1) {
                    pos[i][j] = pos[i][j - 1];
                } else if (pos[i][j - 1] == -1) {
                    pos[i][j] = pos[i - 1][j];
                } else {
                    pos[i][j] = pos[i][j - 1] + pos[i - 1][j];
                }

            }
        }

        System.out.println(pos[x][y]);
    }
}
