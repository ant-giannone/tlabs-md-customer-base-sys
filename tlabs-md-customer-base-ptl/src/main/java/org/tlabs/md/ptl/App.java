package org.tlabs.md.ptl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tlabs.md.bsl.DummyBslComponent;
import org.tlabs.md.bsl.DummyBslComponentImpl;
import org.tlabs.md.dal.DummyDalComponent;
import org.tlabs.md.dal.DummyDalComponentImpl;

public class App {

    private static final Logger logger
            = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {

        DummyDalComponent dummyDalComponent = new DummyDalComponentImpl();
        DummyBslComponent dummyBslComponent = new DummyBslComponentImpl(dummyDalComponent);

        logger.info("Hello! I'm Customer base System");
        logger.info("Check presentation layer: I'm here");
        logger.info("Check business layer: {}", dummyBslComponent.getLayerName());
        logger.info("Check data access layer: {}", dummyBslComponent.getDummyDalComponent().getLayerName());

    }
}
