package com.eplusing.demo1200.prospring5.ch5;

/**
 * @author eplusing
 * @date 2020/4/19
 */
public class Documentarist {
    private GrammyGuitarist guitarist;

    public void execute() {
        guitarist.sing();
        guitarist.talk();
    }

    public void setGuitarist(GrammyGuitarist guitarist) {
        this.guitarist = guitarist;
    }
}
