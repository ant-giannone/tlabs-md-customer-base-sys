package org.tlabs.md.ptl.ws.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationResponse;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerBaseWsImplTest {

    private CustomerBaseWs customerBaseWs;

    @Before
    public void setUp() throws Exception {

        customerBaseWs = spy(CustomerBaseWsImpl.class);
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
    }
}