package com.eplusing.demo1200.prospring5.ch4;

import java.beans.PropertyEditorSupport;

/**
 * @author eplusing
 * @date 2020/2/29
 */
public class NamePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] name = text.split("\\s");
        setValue(new FullName(name[0], name[1]));
    }
}
