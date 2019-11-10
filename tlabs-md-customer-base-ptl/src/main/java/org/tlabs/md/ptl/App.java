package org.tlabs.md.ptl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tlabs.md.bsl.component.DummyBslComponent;
import org.tlabs.md.dal.component.DummyDalComponent;
import org.tlabs.md.ptl.component.DummyPtlComponent;

public class App {

    private static final Logger logger
            = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {

        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        DummyPtlComponent dummyPtlComponent = (DummyPtlComponent) applicationContext.getBean("dummyPtlComponent");
        DummyBslComponent dummyBslComponent = dummyPtlComponent.getDummyBslComponent();
        DummyDalComponent dummyDalComponent = dummyBslComponent.getDummyDalComponent();

        logger.info("Hello! I'm Customer base System");
        logger.info("Check presentation layer: {}", dummyPtlComponent.getLayerName());
        logger.info("Check business layer: {}", dummyBslComponent.getLayerName());
        logger.info("Check data access layer: {}", dummyDalComponent.getLayerName());

        applicationContext.close();
    }
}
