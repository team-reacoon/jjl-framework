package org.jjl.framework.factory;

import org.jjl.framework.factory.type.Scope;

/**
 * 컴포넌트의 메타데이터를 저장하는 객체의 루트
 *
 * @author 김경민
 */
public interface ComponentDefinition {

    void setScope(Scope scope);

    Scope getScope();

    boolean isPrototype();

    boolean isSingleton();

    void setComponentClass(Class<?> componentClass);

    Class<?> getComponentClass();
}
