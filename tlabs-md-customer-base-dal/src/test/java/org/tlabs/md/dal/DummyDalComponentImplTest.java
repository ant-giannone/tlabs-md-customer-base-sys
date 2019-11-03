package org.tlabs.md.dal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DummyDalComponentImplTest {

    private DummyDalComponent dummyDalComponent;

    @Before
    public void setUp() throws Exception {
        dummyDalComponent = mock(DummyDalComponentImpl.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getLayerName() {

        when(dummyDalComponent.getLayerName()).thenReturn("I'm data access layer");
        assertEquals(dummyDalComponent.getLayerName(), "I'm data access layer");
    }
}