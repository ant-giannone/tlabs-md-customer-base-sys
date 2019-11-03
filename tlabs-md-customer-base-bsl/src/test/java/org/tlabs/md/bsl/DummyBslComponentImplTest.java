package org.tlabs.md.bsl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DummyBslComponentImplTest {

    private DummyBslComponent dummyBslComponent;

    @Before
    public void setUp() throws Exception {
        dummyBslComponent = mock(DummyBslComponentImpl.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getLayerName() {

        when(dummyBslComponent.getLayerName()).thenReturn("I'm business layer");
        assertEquals(dummyBslComponent.getLayerName(), "I'm business layer");
    }
}