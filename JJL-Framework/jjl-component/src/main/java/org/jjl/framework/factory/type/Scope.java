package org.jjl.framework.factory.type;

public enum Scope {
    SINGLETON("singleton"),
    PROTOTYPE("prototype");

    private final String name;

    Scope(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
