package org.tlabs.md.ptl.component;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DummyPtlComponentImplTest {

    private ConfigurableApplicationContext applicationContext;

    private DummyBslComponent dummyBslComponent;
    private DummyDalComponent dummyDalComponent;
    private DummyPtlComponent dummyPtlComponent;

    @Before
    public void setUp() throws Exception {

        applicationContext = mock(ClassPathXmlApplicationContext.class);

        dummyDalComponent = spy(new DummyDalComponentImpl());
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
        assertNotNull(dummyPtlComponent.getDummyBslComponent());
        assertEquals("I'm business layer", dummyPtlComponent.getDummyBslComponent().getLayerName());
    }

    @Test
    public void getDummyDalComponent() {

        when(applicationContext.getBean("dummyPtlComponent")).thenReturn(dummyPtlComponent);
        assertNotNull(dummyPtlComponent);
        assertNotNull(dummyPtlComponent.getDummyBslComponent());
        assertNotNull(dummyPtlComponent.getDummyBslComponent().getDummyDalComponent());
        assertEquals("I'm data access layer",
                dummyPtlComponent.getDummyBslComponent().getDummyDalComponent().getLayerName());
    }
}