package org.tlabs.md.ptl.ws.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationRequest;
import org.tlabs.md.ptl.ws.dto.NewUserRegistrationResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class CustomerBaseRegistrationWsImplTest {

    private CustomerBaseRegistrationWs customerBaseWs;

    @Before
    public void setUp() throws Exception {

        customerBaseWs = spy(CustomerBaseRegistrationWsImpl.class);
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