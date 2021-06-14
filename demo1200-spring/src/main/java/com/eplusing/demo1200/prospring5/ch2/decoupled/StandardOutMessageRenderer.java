package com.eplusing.demo1200.prospring5.ch2.decoupled;

/**
 * @author eplusing
 * @date 2019/12/29
 */
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    public StandardOutMessageRenderer() {
        System.out.println("--------StandardOutMessageRenderer constructor called");
    }

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("you must set thie property messageProvider" +
                    " of class " +
                    StandardOutMessageRenderer.class.getName());
        }

        System.out.println(this.getClass().getName() + messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        System.out.println("---------StandardOutMessageRenderer set message providers");
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
