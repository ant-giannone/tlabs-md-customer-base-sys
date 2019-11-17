package org.tlabs.md.ptl.component;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tlabs.md.bsl.component.DummyBslComponent;
import org.tlabs.md.bsl.component.DummyBslComponentImpl;
import org.tlabs.md.dal.component.DummyDalComponent;
import org.tlabs.md.dal.component.DummyDalComponentImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class DummyPtlComponentImplTest {

    private ConfigurableApplicationContext applicationContext;

    private DummyBslComponent dummyBslComponent;
    private DummyDalComponent dummyDalComponent;
    private DummyPtlComponent dummyPtlComponent;

    @Before
    public void setUp() throws Exception {

        applicationContext = mock(ClassPathXmlApplicationContext.class);

        dummyDalComponent = mock(DummyDalComponentImpl.class);
        dummyBslComponent = spy(new DummyBslComponentImpl(dummyDalComponent));
        dummyPtlComponent = spy(new DummyPtlComponentImpl(dummyBslComponent));
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

        when(applicationContext.getBean("dummyPtlComponent")).thenReturn(dummyPtlComponent);

        assertNotNull(dummyPtlComponent);
        assertEquals(dummyPtlComponent.getLayerName(), "I'm presentation layer");
    }

    @Test
    public void getDummyBslComponent() {

        when(applicationContext.getBean("dummyPtlComponent")).thenReturn(dummyPtlComponent);
        assertNotNull(dummyPtlComponent);

        when(dummyPtlComponent.getDummyBslComponent()).thenReturn(dummyBslComponent);
        assertNotNull(dummyBslComponent);
    }
}