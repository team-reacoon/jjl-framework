package org.jjl.framework.factory.support;

import org.jjl.framework.factory.ComponentDefinition;
import org.jjl.framework.factory.ComponentFactory;
import org.jjl.framework.factory.type.Scope;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractComponentFactory implements ComponentFactory {

    private final Map<String, ComponentDefinition> componentDefinitionsMap = new ConcurrentHashMap<>();
    private final Map<String, Class<?>> singletonComponents = new ConcurrentHashMap<>();
    private String factoryName;

    public AbstractComponentFactory() {
        super();
    }

    @Override
    public <T> Object creteComponent(T type, String name, Scope scope){
        ComponentDefinition existingDefinition = componentDefinitionsMap.get(name);
        if(existingDefinition != null){
            synchronized (componentDefinitionsMap){
                ComponentDefinition cd = new GenericComponentDefinition();
                cd.setComponentClass(type.getClass());
                cd.setScope(scope);
                componentDefinitionsMap.put(name, cd);
                existingDefinition = componentDefinitionsMap.get(name);
            }
        }
        else{
            throw new RuntimeException("Component name already exist");
        }

        return existingDefinition;
    }

    @Override
    public Class<?> getComponent(String name) throws IllegalStateException{
        if(!componentDefinitionsMap.containsKey(name)){
            throw new IllegalStateException("Component not exist.");
        }
        else{
            ComponentDefinition componentDefinition = componentDefinitionsMap.get(name);
            if(componentDefinition == null){
                throw new IllegalStateException("can't find component name: " + name);
            }
            if(componentDefinition.isSingleton()){
                if(singletonComponents.containsKey(name)){
                    return singletonComponents.get(name);
                }
                else{
                    Class<?> singletonComponentClass = componentDefinition.getComponentClass();
                    singletonComponents.put(name, singletonComponentClass);
                    return singletonComponentClass;
                }
            }
            else{
                return componentDefinitionsMap.get(name).getComponentClass();
            }
        }
    }

    @Override
    public String getFactoryName(){
        return this.factoryName;
    }

    @Override
    public void setFactoryName(String name){
        this.factoryName = name;
    }
}
