package com.eplusing.demo1200.rpc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RpcServer {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[]{};
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(new byte[]{1,2}));
        in.readUTF();
    }
}
