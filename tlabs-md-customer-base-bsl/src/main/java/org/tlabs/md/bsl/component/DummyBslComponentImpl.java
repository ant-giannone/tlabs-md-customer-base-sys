package org.tlabs.md.bsl.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.tlabs.md.dal.component.DummyDalComponent;
import org.tlabs.md.dal.dao.DummyDAO;
import org.tlabs.md.dal.entity.DummyEntity;

@Transactional(readOnly = true)
public class DummyBslComponentImpl implements DummyBslComponent {

    private static final Logger logger
            = LoggerFactory.getLogger(DummyBslComponentImpl.class);

    private DummyDalComponent dummyDalComponent;
    private DummyDAO dummyDAO;

    public DummyBslComponentImpl(DummyDalComponent dummyDalComponent, DummyDAO dummyDAO) {

        logger.debug("Constructor invoked for: {}", this.getClass().getName());

        this.dummyDAO = dummyDAO;
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

    @Transactional
    @Override
    public void dummyRegister(DummyEntity dummyEntity) {
        dummyDAO.create(dummyEntity);
    }
}
