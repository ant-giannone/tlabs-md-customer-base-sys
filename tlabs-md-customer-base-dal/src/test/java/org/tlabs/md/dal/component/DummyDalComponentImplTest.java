package org.tlabs.md.dal.component;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tlabs.md.dal.component.DummyDalComponent;
import org.tlabs.md.dal.component.DummyDalComponentImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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