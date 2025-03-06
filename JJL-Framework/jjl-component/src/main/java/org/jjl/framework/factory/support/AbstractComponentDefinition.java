package org.jjl.framework.factory.support;

import org.jjl.framework.factory.ComponentDefinition;
import org.jjl.framework.factory.type.Scope;

public abstract class AbstractComponentDefinition implements ComponentDefinition {
    private Class<?> componentClass;
    private Scope scope;

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Scope getScope() {
        return this.scope;
    }

    @Override
    public boolean isPrototype() {
        return (scope == Scope.PROTOTYPE);
    }

    @Override
    public boolean isSingleton() {
        return (scope == Scope.SINGLETON);
    }

    @Override
    public void setComponentClass(Class<?> componentClass) {
        this.componentClass = componentClass;
    }

    @Override
    public Class<?> getComponentClass() throws IllegalStateException{
        Object componentClassObject = this.componentClass;
        if(componentClassObject == null){
            throw new IllegalStateException("componentClass is null");
        }
        return componentClass;
    }
}
