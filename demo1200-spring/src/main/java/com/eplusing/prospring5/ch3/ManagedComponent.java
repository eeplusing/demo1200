package com.eplusing.prospring5.ch3;

import org.apache.catalina.Container;

/**
 * @author eplusing
 * @date 2019/12/30
 */
public interface ManagedComponent {
    void performLookup(Container container);
}
