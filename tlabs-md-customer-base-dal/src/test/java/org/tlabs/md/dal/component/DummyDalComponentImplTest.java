package org.tlabs.md.dal.component;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DummyDalComponentImplTest {

    private ConfigurableApplicationContext applicationContext;
    private DummyDalComponent dummyDalComponent;

    @Before
    public void setUp() throws Exception {
        applicationContext = mock(ClassPathXmlApplicationContext.class);
        dummyDalComponent = new DummyDalComponentImpl();
    }

    @After
    public void tearDown() throws Exception {

        if(applicationContext==null)
            return;

        applicationContext.close();
        applicationContext = null;
    }

    @Test
    public void getLayerName() {

        when(applicationContext.getBean("dummyDalComponent")).thenReturn(dummyDalComponent);
        assertEquals(dummyDalComponent.getLayerName(), "I'm data access layer");
    }
}
