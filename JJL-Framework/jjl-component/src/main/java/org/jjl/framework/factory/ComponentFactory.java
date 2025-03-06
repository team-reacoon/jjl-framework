package org.jjl.framework.factory;
import org.jjl.framework.factory.type.Scope;

import java.util.List;

/**
 * 컴포넌트 생성 Factory의 루트
 * @author Kim Kyungmin
 * @since 1.0
 */
public interface ComponentFactory {

    /**
     * <b>프로토타입,싱글톤</b> 컴포넌트를 생성하는 메소드
     * @param type 프로토타입으로 생성할 컴포넌트
     * @return 프로토타입으로 생성된 컴포넌트
     * @since 1.0
     */
    <T> Object creteComponent(T type, String name, Scope scope);

    /**
     * 캐시에 생성된 컴포넌트가 있으면 캐시에 있는 컴포넌트를 반환, 캐시에 생성된 컴포넌트가 없는 경우 컴포넌트를 생성해서 반환합니다.
     * @param name 컴포넌트 이름
     * @return 생성된 컴포넌트
     * @since 1.0
     */
    Object getComponent(String name) throws IllegalStateException;

    void setFactoryName(String factoryName);

    String getFactoryName();
}
