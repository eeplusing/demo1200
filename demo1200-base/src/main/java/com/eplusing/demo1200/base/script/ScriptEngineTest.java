package com.eplusing.demo1200.base.script;

import javax.script.ScriptEngine;

import javax.script.ScriptEngineManager;

import javax.script.ScriptException;

public class ScriptEngineTest {

    public static void main(String[] args) throws ScriptException {

        int n = 128;

        int m = 24;

        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("js");

        Object o = engine.eval(m + "+" + n);

        System.out.println(o.toString());

    }

}