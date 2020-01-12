package org.tlabs.md.ptl.component;

import org.tlabs.md.bsl.component.DummyBslComponent;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;

public interface DummyPtlComponent {

    public String getLayerName();

    public DummyBslComponent getDummyBslComponent();

    public void newUserRegistration(NewUserRegistrationRequest userRegistrationRequest);
}
