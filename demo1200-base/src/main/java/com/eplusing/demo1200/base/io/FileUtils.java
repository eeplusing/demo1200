package com.eplusing.demo1200.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;


public class FileUtils {
    /**
     * 移动文件
     *
     * @param sourceFilePath源文件全路径
     * @param targetFilePath目标文件全路径
     * @param delSrcFile是否删除源文件
     */
    public static boolean moveArchiveFolder(String sourceFileFolder, String sourceFileName, boolean delSrcFile) {
        try {
            String sourceFilePath = sourceFileFolder + File.separator + sourceFileName;
            Date date = new Date();
            String dateYYYY = new SimpleDateFormat("yyyy").format(date);
            String dateYYYYMM = new SimpleDateFormat("yyyyMM").format(date);
            // 外部配置
            String archiveFilePath = "D:/archive";
            //按日期归档
            String archiveFolder = archiveFilePath + File.separator + dateYYYY + File.separator + dateYYYYMM;
            String targetFilePath = archiveFolder + File.separator + sourceFileName;

            File archivePath = new File(archiveFolder);

            if (!archivePath.exists() || !archivePath.isDirectory()) {
                archivePath.mkdirs();
            }

            copyFile(sourceFilePath, targetFilePath);

            if (delSrcFile) {
                deleteFile(new File(sourceFilePath));
            }

        } catch (Exception e) {
            System.err.println("归档文件失败");
            return false;
        }
        return true;
    }

    public static boolean copyFile(String sourceFilePath, String targetFilePath) {
        FileInputStream fIn = null;
        FileOutputStream fOut = null;
        // 获取源文件和目标文件的输入输出流
        try {
            fIn = new FileInputStream(sourceFilePath);
            fOut = new FileOutputStream(targetFilePath);
            // 获取输入输出通道
            FileChannel fcIn = fIn.getChannel();
            FileChannel fcOut = fOut.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                // clear方法重设缓冲区，使它可以接受读入的数据
                buffer.clear();
                // 从输入通道中将数据读到缓冲区
                int r = fcIn.read(buffer);
                if (r == -1) {
                    break;
                }
                // flip方法让缓冲区可以将新读入的数据写入另一个通道
                buffer.flip();
                fcOut.write(buffer);
            }
        } catch (IOException e) {
            System.err.println("复制文件失败");
            return false;
        } finally {
            if (fIn != null && fOut != null) {
                try {
                    fIn.close();
                    fOut.close();
                } catch (IOException e) {
                    System.err.println("关闭文件读写失败");
                }
            }
        }
        return true;
    }


    public static boolean deleteDirectory(String dir) throws IOException {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            System.err.println("删除目录失败：" + dir + "不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i]);
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            System.out.println("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            System.out.println("删除目录" + dir + "成功！");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除单个文件
     */
    public static boolean deleteFile(File file) throws IOException {
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }


    // ****************同一时刻只能有一个线程读取文件start****************//
    // 同一时刻只能有一个线程读取该文件使用方法
    public static void testFileLock() {
        File file = new File("sourceFilePath");
        long startTime = System.currentTimeMillis();
        while (true) {
            // 一个文件只允许同时有一个线程在处理
            if (isReadable(file.getName())) {
                // TODO 1.处理文件逻辑

                // 2.最后释放该文件
                fileLockMap.remove(file.getName());
                break;
            }
            // 3.超时退出 60秒
            long currTime = System.currentTimeMillis();
            if (currTime - startTime > 60000) {
                break;
            }
        }
    }

    // 文件锁
    public static ConcurrentHashMap<String, String> fileLockMap = new ConcurrentHashMap<String, String>();

    public static boolean isReadable(String fileName) {
        if (fileLockMap.get(fileName) != null) {
            return false;
        } else {
            synchronized (Object.class) {
                if (fileLockMap.get(fileName) != null) {
                    return false;
                } else {
                    fileLockMap.put(fileName, fileName);
                    return true;
                }
            }
        }
    }
    // ****************同一时刻只能有一个线程读取文件end****************//
}