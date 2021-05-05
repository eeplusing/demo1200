package com.eplusing.sm;


import java.util.Arrays;
import org.apache.commons.codec.binary.Base64;

public class SM4 {
    //commons-codec-1.9.jar
    private static final int ENCRYPT = 1;
    private static final int DECRYPT = 0;
    public static final int ROUND = 32;
    private static final int BLOCK = 16;

    /**
     * plainStr:待加密的明文
     * sm4HexKey：16进制的秘钥
     * charSet：原字符串编码
     * */
    public static String Encrypt(String plainStr, String sm4HexKey, String charSet) throws Exception {
        String mode = "ECB";
        String cipherStr = null;
        byte[] in = null;
        byte[] key = null;
        byte[] out = null;

        try {
            in = plainStr.getBytes(charSet);
            key = hexStringToBytes(sm4HexKey);
            in = paddingWith80(in, ENCRYPT);
            out = Encrypt(in, key, mode);
        } catch (Exception e) {
            System.err.println("sm4 encrypt error");
            // throw new SelfException();
        }

        if (null != out) {
            cipherStr = bytesToHex(out).toUpperCase();
        }

        return cipherStr;
    }


    public static String encryptBase64Str(byte[] in, byte[] key, String charset) {
        String mode = "ECB";
        String cipherStr = null;

        byte[] out = null;

        try {
            in = pkcs5pading(in, ENCRYPT);
            out = Encrypt(in, key, mode);
        } catch (Exception e) {
            System.err.println("sm4 encrypt error");
            // throw new SelfException();
        }

        if (null != out) {
            cipherStr = Base64.encodeBase64String(out);
        }

        return cipherStr;
    }

    /**
     * cipherStr:密文
     * sm4HexKey：16进制的秘钥
     * charSet：原字符串编码
     *  默认ECB模式
     * */
    public static String decryptBase64(byte[] in, byte[] key, String charSet) throws Exception {
        String mode = "ECB";
        String plainStr = null;

        byte[] out = null;

        try {
            out = Decrypt(in, key, mode);
        } catch (Exception e) {
            System.err.println("sm4 encrypt error");
            // throw new SelfException();
        }

        if (null != out) {
            out = pkcs5pading(out, DECRYPT);
            plainStr = new String(out, charSet);
        }

        return plainStr;
    }

    public static byte[] decryptBase64(byte[] in, byte[] key) throws Exception {
        String mode = "ECB";
        String plainStr = null;

        byte[] out = null;

        try {
            out = Decrypt(in, key, mode);
        } catch (Exception e) {
            System.err.println("sm4 encrypt error");
            // throw new SelfException();
        }

        if (null != out) {
            out = pkcs5pading(out, DECRYPT);

        }

        return out;
    }

    private static byte[] pkcs5pading(byte[] in, int mode) {
        if (in == null) {
            return null;
        }

        int inLen = in.length;
        byte[] ret = (byte[]) null;
        if (mode == ENCRYPT) {
            int p = 16 - inLen % 16;
            ret = new byte[inLen + p];
            System.arraycopy(in, 0, ret, 0, inLen);
            for (int i = 0; i < p ; i++) {
                ret[inLen + i] = (byte) p;
            }

        } else {
            int p = in[inLen - 1];
            ret = new byte[inLen - p];
            System.arraycopy(in, 0, ret, 0, inLen - p);
        }
        return ret;
    }


    /**
     * cipherStr:密文
     * sm4HexKey：16进制的秘钥
     * charSet：原字符串编码
     *  默认ECB模式
     * */
    public static String Decrypt(String cipherStr, String sm4HexKey, String charSet) throws Exception {
        String mode = "ECB";
        String plainStr = null;
        byte[] in = null;
        byte[] key = null;
        byte[] out = null;

        try {
            in = hexStringToBytes(cipherStr);
            key = hexStringToBytes(sm4HexKey);
            out = Decrypt(in, key, mode);
        } catch (Exception e) {
            System.err.println("sm4 encrypt error");
            // throw new SelfException();
        }

        if (null != out) {
            out = paddingWith80(out, DECRYPT);
            plainStr = new String(out, charSet);
        }

        return plainStr;
    }

    /*
     * private static byte[] hexStringToBytes(String hexStr) { int len =
     * hexStr.length(); String hexFlag = "0x"; if (32 != len) {
     * System.err.println("the HEX key string length must be 32"); } byte[] keys
     * = new byte[16];
     *
     * for (int i = 0; i < len; i = i + 2) { keys[i] = Byte.decode(hexFlag +
     * hexStr.substring(i, i + 2)); System.out.println(keys[i]); }
     *
     * return keys; }
     */

    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() < 2) {
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
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

    /**
     * Convert char to byte
     *
     * @param c
     *            char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static String Encrypt(String plainStr, String sms4HexKey, String mode, String charSet) throws Exception {

        return null;
    }

    private static byte[] paddingWith00(byte[] input, int mode) {
        if (input == null) {
            return null;
        }

        int inLen = input.length;

        byte[] ret = (byte[]) null;

        byte pad00 = (byte) 0x00;

        if (mode == ENCRYPT) {
            int temp = inLen % 16;
            // 16字节的整数倍不需要填充
            if (temp == 0) {
                return input;
            }

            // 填充的字节数
            int p = 16 - temp;
            ret = new byte[inLen + p];
            System.arraycopy(input, 0, ret, 0, input.length);
            // 填充00字节
            for (int i = 0; i < p; i++) {
                ret[inLen + i] = pad00;
            }
        } else {
            int index = inLen - 1;
            int endFlag = inLen - 16;
            // 查找最后一个不是00字节所在位置 仅检测最后15字节是否含有80字节
            for (; index > endFlag; index--) {
                if (input[index] != pad00) {
                    break;
                }
            }

            // 密文为16字节的情况下 且不含补位的00字节 则直接返回原值
            if (index < 1) {
                return input;
            }

            ret = new byte[index + 1];
            // 仅保留至首个非00字节之前
            System.arraycopy(input, 0, ret, 0, index + 1);
        }
        return ret;
    }

    /**
     * 不论是否是16字节都填充0x80,
     * **/
    private static byte[] paddingWith80(byte[] input, int mode) {
        if (input == null) {
            return null;
        }

        int inLen = input.length;

        byte[] ret = (byte[]) null;

        byte pad80 = (byte) 0x80;
        byte pad00 = (byte) 0x00;

        if (mode == ENCRYPT) {
            int temp = inLen % 16;
			/*
			 * 贵州银行加密机强制补位
			 * // 16字节的整数倍不需要填充
			if (temp == 0) {
				return input;
			}*/

            // 填充的字节数
            int p = 16 - temp;
            ret = new byte[input.length + p];
            System.arraycopy(input, 0, ret, 0, input.length);
            // 填充80字节
            ret[input.length] = pad80;
            // 填充00字节
            for (int i = 1; i < p; i++) {
                ret[input.length + i] = pad00;
            }
        } else {
            int index = inLen - 1;
            int endFlag = inLen - 16;
            int pad80Flag = 0;
            // 查找最后一个80字节所在位置 仅检测最后15字节是否含有80字节
            for (; index >= endFlag; index--) {
                if (input[index] == pad80) {
                    pad80Flag = 1;
                    break;
                }
            }

            // 不含补位的80字节 则直接返回原值
            if (pad80Flag == 0) {
                return input;
            }

            ret = new byte[index];
            // 仅保留80字节之前
            System.arraycopy(input, 0, ret, 0, index);
        }
        return ret;
    }

    public static byte[] Encrypt(byte[] in, byte[] key, String mode) {

        int cipherLen = in.length;
        byte[] out = new byte[cipherLen];

        SM4 sm4 = new SM4();
        sm4.sm4ECB(in, key, out, ENCRYPT);

        return out;
    }

    public static byte[] Decrypt(byte[] in, byte[] key, String mode) {
        int cipherLen = in.length;
        byte[] out = new byte[cipherLen];

        SM4 sm4 = new SM4();
        sm4.sm4ECB(in, key, out, DECRYPT);

        return out;
    }

    /**
     * @param whatToDecrypt
     * @param aesHexKey
     * @return
     * @throws Exception
     */
    // TODO
    public static String decrypt(String whatToDecrypt, String aesHexKey) throws Exception {


        return null;

    }

    private static final long[] FK = { 0xa3b1bac6L, 0x56aa3350L, 0x677d9197L, 0xb27022dcL };

    private static final byte[] Sbox = { (byte) 0xd6, (byte) 0x90, (byte) 0xe9, (byte) 0xfe, (byte) 0xcc, (byte) 0xe1, 0x3d, (byte) 0xb7, 0x16, (byte) 0xb6, 0x14, (byte) 0xc2, 0x28, (byte) 0xfb, 0x2c, 0x05, 0x2b, 0x67, (byte) 0x9a, 0x76, 0x2a, (byte) 0xbe, 0x04, (byte) 0xc3, (byte) 0xaa, 0x44, 0x13, 0x26, 0x49, (byte) 0x86, 0x06, (byte) 0x99, (byte) 0x9c, 0x42, 0x50, (byte) 0xf4, (byte) 0x91, (byte) 0xef, (byte) 0x98, 0x7a, 0x33, 0x54, 0x0b, 0x43, (byte) 0xed, (byte) 0xcf, (byte) 0xac, 0x62, (byte) 0xe4, (byte) 0xb3, 0x1c, (byte) 0xa9, (byte) 0xc9, 0x08, (byte) 0xe8, (byte) 0x95, (byte) 0x80, (byte) 0xdf, (byte) 0x94, (byte) 0xfa, 0x75, (byte) 0x8f, 0x3f, (byte) 0xa6, 0x47, 0x07, (byte) 0xa7, (byte) 0xfc, (byte) 0xf3, 0x73, 0x17, (byte) 0xba, (byte) 0x83, 0x59, 0x3c, 0x19, (byte) 0xe6,
            (byte) 0x85, 0x4f, (byte) 0xa8, 0x68, 0x6b, (byte) 0x81, (byte) 0xb2, 0x71, 0x64, (byte) 0xda, (byte) 0x8b, (byte) 0xf8, (byte) 0xeb, 0x0f, 0x4b, 0x70, 0x56, (byte) 0x9d, 0x35, 0x1e, 0x24, 0x0e, 0x5e, 0x63, 0x58, (byte) 0xd1, (byte) 0xa2, 0x25, 0x22, 0x7c, 0x3b, 0x01, 0x21, 0x78, (byte) 0x87, (byte) 0xd4, 0x00, 0x46, 0x57, (byte) 0x9f, (byte) 0xd3, 0x27, 0x52, 0x4c, 0x36, 0x02, (byte) 0xe7, (byte) 0xa0, (byte) 0xc4, (byte) 0xc8, (byte) 0x9e, (byte) 0xea, (byte) 0xbf, (byte) 0x8a, (byte) 0xd2, 0x40, (byte) 0xc7, 0x38, (byte) 0xb5, (byte) 0xa3, (byte) 0xf7, (byte) 0xf2, (byte) 0xce, (byte) 0xf9, 0x61, 0x15, (byte) 0xa1, (byte) 0xe0, (byte) 0xae, 0x5d, (byte) 0xa4, (byte) 0x9b, 0x34, 0x1a, 0x55, (byte) 0xad, (byte) 0x93, 0x32, 0x30, (byte) 0xf5, (byte) 0x8c, (byte) 0xb1,
            (byte) 0xe3, 0x1d, (byte) 0xf6, (byte) 0xe2, 0x2e, (byte) 0x82, 0x66, (byte) 0xca, 0x60, (byte) 0xc0, 0x29, 0x23, (byte) 0xab, 0x0d, 0x53, 0x4e, 0x6f, (byte) 0xd5, (byte) 0xdb, 0x37, 0x45, (byte) 0xde, (byte) 0xfd, (byte) 0x8e, 0x2f, 0x03, (byte) 0xff, 0x6a, 0x72, 0x6d, 0x6c, 0x5b, 0x51, (byte) 0x8d, 0x1b, (byte) 0xaf, (byte) 0x92, (byte) 0xbb, (byte) 0xdd, (byte) 0xbc, 0x7f, 0x11, (byte) 0xd9, 0x5c, 0x41, 0x1f, 0x10, 0x5a, (byte) 0xd8, 0x0a, (byte) 0xc1, 0x31, (byte) 0x88, (byte) 0xa5, (byte) 0xcd, 0x7b, (byte) 0xbd, 0x2d, 0x74, (byte) 0xd0, 0x12, (byte) 0xb8, (byte) 0xe5, (byte) 0xb4, (byte) 0xb0, (byte) 0x89, 0x69, (byte) 0x97, 0x4a, 0x0c, (byte) 0x96, 0x77, 0x7e, 0x65, (byte) 0xb9, (byte) 0xf1, 0x09, (byte) 0xc5, 0x6e, (byte) 0xc6, (byte) 0x84, 0x18, (byte) 0xf0, 0x7d,
            (byte) 0xec, 0x3a, (byte) 0xdc, 0x4d, 0x20, 0x79, (byte) 0xee, 0x5f, 0x3e, (byte) 0xd7, (byte) 0xcb, 0x39, 0x48 };

    private static long[] CK = { 0x00070e15L, 0x1c232a31L, 0x383f464dL, 0x545b6269L, 0x70777e85L, 0x8c939aa1L, 0xa8afb6bdL, 0xc4cbd2d9L, 0xe0e7eef5L, 0xfc030a11L, 0x181f262dL, 0x343b4249L, 0x50575e65L, 0x6c737a81L, 0x888f969dL, 0xa4abb2b9L, 0xc0c7ced5L, 0xdce3eaf1L, 0xf8ff060dL, 0x141b2229L, 0x30373e45L, 0x4c535a61L, 0x686f767dL, 0x848b9299L, 0xa0a7aeb5L, 0xbcc3cad1L, 0xd8dfe6edL, 0xf4fb0209L, 0x10171e25L, 0x2c333a41L, 0x484f565dL, 0x646b7279L };

    private int Rotl(int x, int y) {
        return x << y | x >>> (32 - y);
    }

    private int T(int B) {
        return B ^ Rotl(B, 2) ^ Rotl(B, 10) ^ Rotl(B, 18) ^ Rotl(B, 24);
    }

    private int ByteSub(int mid) {
        return (Sbox[(int) (mid >>> 24 & 0xFF)] & 0xFF) << 24 | (Sbox[(int) (mid >>> 16 & 0xFF)] & 0xFF) << 16 | (Sbox[(int) (mid >>> 8 & 0xFF)] & 0xFF) << 8 | (Sbox[(int) (mid & 0xFF)] & 0xFF);
    }

    private void SMS4Crypt(byte[] input, byte[] output, long[] rk) {
        long X = 0L;
        long B = 0L;

        int r;

        long[] x = new long[4];

        x[0] = GET_ULONG_BE(input, 0);
        x[1] = GET_ULONG_BE(input, 4);
        x[2] = GET_ULONG_BE(input, 8);
        x[3] = GET_ULONG_BE(input, 12);

        for (r = 0; r < 32; r += 4) {
            X = x[1] ^ x[2] ^ x[3] ^ (int) rk[r + 0];

            B = ByteSub((int) X);
            x[0] = x[0] ^ T((int) B) & 0xffffffffL; // x4
            // System.out.println("X[" + (r + 1) + "]=" +

            X = x[2] ^ x[3] ^ x[0] ^ (int) rk[r + 1];
            B = ByteSub((int) X);
            x[1] = x[1] ^ T((int) B) & 0xffffffffL; // x5
            // System.out.println("X[" + (r + 2) + "]=" +

            X = x[3] ^ x[0] ^ x[1] ^ (int) rk[r + 2];
            B = ByteSub((int) X);
            x[2] = x[2] ^ T((int) B) & 0xffffffffL; // x6
            // System.out.println("X[" + (r + 3) + "]=" +

            X = x[0] ^ x[1] ^ x[2] ^ (int) rk[r + 3];
            B = ByteSub((int) X);
            x[3] = x[3] ^ T((int) B) & 0xffffffffL; // x7
            // System.out.println("X[" + (r +4) + "]=" +
        }

        // Reverse
        for (int j = 0; j < 16; j += 4) {
            output[j] = (byte) (x[3 - j / 4] >>> 24 & 0xFF);
            output[j + 1] = (byte) (x[3 - j / 4] >>> 16 & 0xFF);
            output[j + 2] = (byte) (x[3 - j / 4] >>> 8 & 0xFF);
            output[j + 3] = (byte) (x[3 - j / 4] & 0xFF);
        }

    }

    private byte sm4Sbox(byte inch) {
        int i = inch & 0xFF;
        byte retVal = Sbox[i];
        return retVal;
    }

    private void PUT_ULONG_BE(long n, byte[] b, int i) {
        b[i] = (byte) (int) (0xFF & n >> 24);
        b[i + 1] = (byte) (int) (0xFF & n >> 16);
        b[i + 2] = (byte) (int) (0xFF & n >> 8);
        b[i + 3] = (byte) (int) (0xFF & n);
    }

    private long GET_ULONG_BE(byte[] b, int i) {
        long n = (long) (b[i] & 0xff) << 24 | (long) ((b[i + 1] & 0xff) << 16) | (long) ((b[i + 2] & 0xff) << 8) | (long) (b[i + 3] & 0xff);
        return n;
    }

    private long sm4CalciRK(long ka) {
        long bb = 0;
        long rk = 0;
        byte[] a = new byte[4];
        byte[] b = new byte[4];
        PUT_ULONG_BE(ka, a, 0);
        b[0] = sm4Sbox(a[0]);
        b[1] = sm4Sbox(a[1]);
        b[2] = sm4Sbox(a[2]);
        b[3] = sm4Sbox(a[3]);
        bb = GET_ULONG_BE(b, 0);
        rk = bb ^ ROTL(bb, 13) ^ ROTL(bb, 23);
        return rk;
    }

    private long ROTL(long x, int n) {
        return SHL(x, n) | x >> (32 - n);
    }

    private long SHL(long x, int n) {
        return (x & 0xFFFFFFFFL) << n;
    }

    private void SM4KeyExt(byte[] Key, long[] rk, int CryptFlag) {
        long[] MK = new long[4];
        long[] K = new long[36];

        // 对原始128位秘钥进行分组
        MK[0] = GET_ULONG_BE(Key, 0);
        MK[1] = GET_ULONG_BE(Key, 4);
        MK[2] = GET_ULONG_BE(Key, 8);
        MK[3] = GET_ULONG_BE(Key, 12);

        K[0] = MK[0] ^ FK[0];
        K[1] = MK[1] ^ FK[1];
        K[2] = MK[2] ^ FK[2];
        K[3] = MK[3] ^ FK[3];

        long B = 0L;
        for (int i = 0; i < 32; i++) {
            B = K[(i + 1)] ^ K[(i + 2)] ^ K[(i + 3)] ^ (long) CK[i];
            K[(i + 4)] = (K[i] ^ sm4CalciRK(B) & 0xffffffffL);
            rk[i] = K[(i + 4)];
        }

        long mid;
        // 解密时轮密钥使用顺序：rk31,rk30,...,rk0
        if (CryptFlag == DECRYPT) {
            for (int r = 0; r < 16; r++) {
                mid = rk[r];
                rk[r] = rk[31 - r];
                rk[31 - r] = mid;
            }
        }
    }

    public int sm4ECB(byte[] in, byte[] key, byte[] out, int CryptFlag) {
        int inLen = in.length;
        int point = 0;
        long[] rk = new long[ROUND];

        // 扩张秘钥算法
        SM4KeyExt(key, rk, CryptFlag);

        byte[] input = new byte[16];
        byte[] output = new byte[16];

        while (inLen >= BLOCK) {
            input = Arrays.copyOfRange(in, point, point + 16);
            SMS4Crypt(input, output, rk);
            System.arraycopy(output, 0, out, point, BLOCK);
            inLen -= BLOCK;
            point += BLOCK;
        }

        return 0;
    }


}
