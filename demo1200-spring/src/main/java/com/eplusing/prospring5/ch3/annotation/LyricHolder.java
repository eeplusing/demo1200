package com.eplusing.prospring5.ch3.annotation;

import com.eplusing.prospring5.ch3.ContentHolder;
import org.springframework.stereotype.Service;

/**
 * @author eplusing
 * @date 2020/1/13
 */
@Service("lyricHolder")
public class LyricHolder implements ContentHolder {
    private String value ="you be a dj,I'll be the driver";

    @Override
    public String toString() {
        return "LyricHolder{"  + value + "}";
    }
}
