package org.tlabs.md.ptl.ws.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.tlabs.md.ptl.ws.dto.ActivationAccountRequest;
import org.tlabs.md.ptl.ws.dto.ActivationAccountResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

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
    public void activationAccount() {

        ActivationAccountRequest activationAccountRequest = mock(ActivationAccountRequest.class);
        ActivationAccountResponse activationAccountResponse = customerBaseWs.activationAccount(activationAccountRequest);

        assertNotNull(activationAccountResponse);
        assertEquals("NUR-S01", activationAccountResponse.getOperationCode());
    }
}