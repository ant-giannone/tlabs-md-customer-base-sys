package org.tlabs.md.ptl.ws.soap;

import org.tlabs.md.ptl.dto.LayersInfoDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public interface DummyWebService {

    @WebMethod(operationName="acquireLayers", action = "getLayersInfo")
    public LayersInfoDTO acquireLayers();
}
