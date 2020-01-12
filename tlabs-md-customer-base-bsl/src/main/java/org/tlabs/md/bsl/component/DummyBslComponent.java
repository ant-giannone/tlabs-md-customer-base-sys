package org.tlabs.md.bsl.component;

import org.tlabs.md.dal.component.DummyDalComponent;
import org.tlabs.md.dal.entity.DummyEntity;

public interface DummyBslComponent {

    public String getLayerName();

    public DummyDalComponent getDummyDalComponent();

    void dummyRegister(DummyEntity dummyEntity);
}
