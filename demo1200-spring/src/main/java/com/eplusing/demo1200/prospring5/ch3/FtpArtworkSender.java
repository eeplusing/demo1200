package com.eplusing.demo1200.prospring5.ch3;

/**
 * @author eplusing
 * @date 2020/1/13
 */
public class FtpArtworkSender implements ArtWorkSender {
    @Override
    public void sendArtwork(String artworkPath, Recipient recipient) {

    }

    @Override
    public String getFriendName() {
        return "File Transfer Protocol";
    }

    @Override
    public String getShortName() {
        return "ftp";
    }
}
