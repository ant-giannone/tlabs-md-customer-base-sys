package org.tlabs.md.bsl.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tlabs.md.dal.component.DummyDalComponent;

public class DummyBslComponentImpl implements DummyBslComponent {

    private static final Logger logger
            = LoggerFactory.getLogger(DummyBslComponentImpl.class);

    private DummyDalComponent dummyDalComponent;

    public DummyBslComponentImpl(DummyDalComponent dummyDalComponent) {

        logger.debug("Constructor invoked for: {}", this.getClass().getName());

        this.dummyDalComponent = dummyDalComponent;
    }

    @Override
    public String getLayerName() {
        return "I'm business layer";
    }

    @Override
    public DummyDalComponent getDummyDalComponent() {
        return dummyDalComponent;
    }
}
