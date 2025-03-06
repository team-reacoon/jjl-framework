package org.jjl.framework.core;

import org.jjl.framework.factory.ComponentFactory;

public interface IoCCore extends ComponentFactory {

    String getId();

    String getApplicationName();

    String getDisplayName();
}
