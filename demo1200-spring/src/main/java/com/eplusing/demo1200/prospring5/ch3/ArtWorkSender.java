package com.eplusing.demo1200.prospring5.ch3;

/**
 * @author eplusing
 * @date 2020/1/13
 */
public interface ArtWorkSender {
    void sendArtwork(String artworkPath, Recipient recipient);
    String getFriendName();
    String getShortName();
}
