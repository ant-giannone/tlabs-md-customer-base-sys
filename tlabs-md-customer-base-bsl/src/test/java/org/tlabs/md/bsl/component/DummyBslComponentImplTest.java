package org.tlabs.md.bsl.component;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tlabs.md.dal.component.DummyDalComponent;
import org.tlabs.md.dal.component.DummyDalComponentImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class DummyBslComponentImplTest {

    private ConfigurableApplicationContext applicationContext;
    private DummyBslComponent dummyBslComponent;
    private DummyDalComponent dummyDalComponent;

    @Before
    public void setUp() throws Exception {

        applicationContext = mock(ClassPathXmlApplicationContext.class);

        dummyDalComponent = mock(DummyDalComponentImpl.class);
        dummyBslComponent = spy(new DummyBslComponentImpl(dummyDalComponent));
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

        when(applicationContext.getBean("dummyBslComponent")).thenReturn(dummyBslComponent);

        assertNotNull(dummyBslComponent);
        assertEquals(dummyBslComponent.getLayerName(), "I'm business layer");
    }

    @Test
    public void getDummyDalComponent() {

        when(applicationContext.getBean("dummyBslComponent")).thenReturn(dummyBslComponent);
        assertNotNull(dummyBslComponent);

        when(dummyBslComponent.getDummyDalComponent()).thenReturn(dummyDalComponent);
        assertNotNull(dummyDalComponent);
    }
}