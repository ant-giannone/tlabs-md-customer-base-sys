package org.tlabs.md.dal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyDalComponentImpl implements DummyDalComponent {

    private static final Logger logger
            = LoggerFactory.getLogger(DummyDalComponentImpl.class);

    public DummyDalComponentImpl() {
        logger.info("Constructor invoked for: {}", this.getClass().getName());
    }

    @Override
    public String getLayerName() {
        return "I'm data access layer";
    }
}
