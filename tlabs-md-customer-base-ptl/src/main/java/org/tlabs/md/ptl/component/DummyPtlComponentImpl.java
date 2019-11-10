package org.tlabs.md.ptl.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tlabs.md.bsl.component.DummyBslComponent;

public class DummyPtlComponentImpl implements DummyPtlComponent {

    private static final Logger logger
            = LoggerFactory.getLogger(DummyPtlComponentImpl.class);

    private DummyBslComponent dummyBslComponent;

    public DummyPtlComponentImpl(DummyBslComponent dummyBslComponent) {

        logger.debug("Constructor invoked for: {}", this.getClass().getName());

        this.dummyBslComponent = dummyBslComponent;
    }

    @Override
    public String getLayerName() {
        return "I'm presentation layer";
    }

    @Override
    public DummyBslComponent getDummyBslComponent() {
        return dummyBslComponent;
    }

}
