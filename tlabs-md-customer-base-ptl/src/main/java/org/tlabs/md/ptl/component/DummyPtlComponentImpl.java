package org.tlabs.md.ptl.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tlabs.md.bsl.component.DummyBslComponent;
import org.tlabs.md.dal.entity.DummyEntity;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;

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

    @Override
    public void newUserRegistration(NewUserRegistrationRequest userRegistrationRequest) {

        /**
         * YOUR CODE HERE...
         * Conversion Pojo to Pojo from SOAP Request to Entity models
         * Invoke business layer component to execute operations on DB by DAO components injected into service layer
         *
         * Fake logic used to test persistence
         * */

        DummyEntity dummyEntity = new DummyEntity();
        dummyEntity.setName("dummy");

        dummyBslComponent.dummyRegister(dummyEntity);
    }
}
