package com.eplusing.prospring5.ch5;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class ErrorBean {
    public void errorProneMethod() throws Exception {
        throw new Exception("Generic Exception");
    }

    public void otherErrorException() throws IllegalArgumentException {
        throw new IllegalArgumentException("IllegalArgument Exception");

    }
}
