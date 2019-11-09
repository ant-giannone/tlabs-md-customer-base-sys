package org.tlabs.md.ptl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tlabs.md.bsl.DummyBslComponent;
import org.tlabs.md.bsl.DummyBslComponentImpl;
import org.tlabs.md.dal.DummyDalComponent;
import org.tlabs.md.dal.DummyDalComponentImpl;

public class App {

    private static final Logger logger
            = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        DummyPtlComponent dummyPtlComponent = (DummyPtlComponent) applicationContext.getBean("dummyPtlComponent");
        DummyBslComponent dummyBslComponent = dummyPtlComponent.getDummyBslComponent();
        DummyDalComponent dummyDalComponent = dummyBslComponent.getDummyDalComponent();

        logger.info("Hello! I'm Customer base System");
        logger.info("Check presentation layer: {}", dummyPtlComponent.getLayerName());
        logger.info("Check business layer: {}", dummyBslComponent.getLayerName());
        logger.info("Check data access layer: {}", dummyDalComponent.getLayerName());
    }
}
