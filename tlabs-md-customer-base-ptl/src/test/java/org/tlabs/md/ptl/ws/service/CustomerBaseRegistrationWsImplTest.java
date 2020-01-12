package org.tlabs.md.ptl.ws.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tlabs.md.bsl.component.DummyBslComponent;
import org.tlabs.md.bsl.component.DummyBslComponentImpl;
import org.tlabs.md.dal.component.DummyDalComponent;
import org.tlabs.md.dal.component.DummyDalComponentImpl;
import org.tlabs.md.dal.dao.DummyDAO;
import org.tlabs.md.ptl.component.DummyPtlComponent;
import org.tlabs.md.ptl.component.DummyPtlComponentImpl;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class CustomerBaseRegistrationWsImplTest {

    private ConfigurableApplicationContext applicationContext;

    private DummyBslComponent dummyBslComponent;
    private DummyDalComponent dummyDalComponent;
    private DummyPtlComponent dummyPtlComponent;
    private DummyDAO dummyDAO;
    private CustomerBaseRegistrationWs customerBaseWs;

    @Before
    public void setUp() throws Exception {

        applicationContext = mock(ClassPathXmlApplicationContext.class);

        dummyDAO = mock(DummyDAO.class);
        dummyDalComponent = spy(new DummyDalComponentImpl());
        dummyBslComponent = spy(new DummyBslComponentImpl(dummyDalComponent, dummyDAO));
        dummyPtlComponent = spy(new DummyPtlComponentImpl(dummyBslComponent));
        customerBaseWs = spy(new CustomerBaseRegistrationWsImpl(dummyPtlComponent));
    }

    @After
    public void tearDown() throws Exception {

        if(customerBaseWs==null)
            return;

        customerBaseWs = null;
    }

    @Test
    public void newUserRegistration() {

        NewUserRegistrationRequest newUserRegistrationRequest = mock(NewUserRegistrationRequest.class);

        NewUserRegistrationResponse newUserRegistrationResponse =
                customerBaseWs.newUserRegistration(newUserRegistrationRequest);

        assertNotNull(newUserRegistrationResponse);
        assertEquals("NUR-S00", newUserRegistrationResponse.getOperationCode());
        assertTrue(newUserRegistrationResponse.getActivationCode()!=null &&
                !"".equals(newUserRegistrationResponse.getActivationCode()));
    }
}