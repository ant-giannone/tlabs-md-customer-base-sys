package org.tlabs.md.ptl.ws.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tlabs.md.ptl.component.DummyPtlComponent;
import org.tlabs.md.ptl.dto.LayersInfoDTO;

import javax.jws.WebService;

@WebService(
        endpointInterface = "org.tlabs.md.ptl.ws.soap.DummyWebService",
        serviceName = "dummyWebService"
)
public class DummyWebServiceImpl implements DummyWebService {

    private static final Logger logger = LoggerFactory.getLogger(DummyWebServiceImpl.class);

    private DummyPtlComponent dummyPtlComponent;

    public DummyWebServiceImpl() {
    }

    public DummyWebServiceImpl(DummyPtlComponent dummyPtlComponent) {
        this.dummyPtlComponent = dummyPtlComponent;
    }

    @Override
    public LayersInfoDTO acquireLayers() {

        LayersInfoDTO layersInfoDTO = new LayersInfoDTO();

        layersInfoDTO.setPresentationLayerInfo(dummyPtlComponent.getLayerName());
        layersInfoDTO.setBusinessLayerInfo(dummyPtlComponent.getDummyBslComponent().getLayerName());
        layersInfoDTO.setDataAccessLayerInfo(dummyPtlComponent.getDummyBslComponent().getDummyDalComponent().getLayerName());

        logger.info("Hello! I'm Customer base System");
        logger.info("Check presentation layer: {}", dummyPtlComponent.getLayerName());
        logger.info("Check business layer: {}", dummyPtlComponent.getDummyBslComponent().getLayerName());
        logger.info("Check data access layer: {}", dummyPtlComponent.getDummyBslComponent().getDummyDalComponent().getLayerName());

        return layersInfoDTO;
    }
}
