package org.tlabs.md.bsl.component;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tlabs.md.bsl.utils.ActivationCodeHelper;
import org.tlabs.md.dal.dao.*;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class CustomerBaseServiceImplTest {

    private ConfigurableApplicationContext applicationContext;
    private CustomerBaseService customerBaseService;
    private ActivationCodeHelper activationCodeHelper;
    private ProfileDAO profileDAO;
    private AccountDAO accountDAO;
    private ContactDAO contactDAO;

    @Before
    public void setUp() throws Exception {

        applicationContext = mock(ClassPathXmlApplicationContext.class);
        activationCodeHelper = new ActivationCodeHelper(UUID.randomUUID());
        profileDAO = mock(ProfileDAOImpl.class);
        accountDAO = mock(AccountDAOImpl.class);
        contactDAO = mock(ContactDAOImpl.class);

        customerBaseService = spy(new CustomerBaseServiceImpl(activationCodeHelper, profileDAO, accountDAO, contactDAO));
    }

    @After
    public void tearDown() throws Exception {

        if(applicationContext==null)
            return;

        applicationContext.close();
        applicationContext = null;
    }

    @Test
    public void dummyTest() {
        Assert.assertTrue(true);
    }
}