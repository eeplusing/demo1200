package com.eplusing.demo1200.prospring5.ch3;

import org.apache.catalina.Container;

/**
 * @author eplusing
 * @date 2019/12/30
 */
public class ContextualizedDependencyLookup implements ManagedComponent {
    //private Dependecy dependecy;
    @Override
    public void performLookup(Container container) {
        //this.dependecy = container.getDependecy("myDependency");
    }

    @Override
    public String toString(){
        //return dependecy.toString();
        return null;
    }
}
