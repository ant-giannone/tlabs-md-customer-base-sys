package org.tlabs.md.ws.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyComponentImpl implements DummyComponent {

    private static final Logger logger = LoggerFactory.getLogger(DummyComponentImpl.class);

    public DummyComponentImpl() {
        logger.info("HELLO!!! I'M HERE FROM SPRING BUNDLE");
    }

    @Override
    public void welcome() {
        logger.info("HELLO!!! I'M HERE FROM SPRING BUNDLE");
    }
}
