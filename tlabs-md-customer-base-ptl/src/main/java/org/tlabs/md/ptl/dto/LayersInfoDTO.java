package org.tlabs.md.ptl.dto;

public class LayersInfoDTO {

    private String presentationLayerInfo;
    private String businessLayerInfo;
    private String dataAccessLayerInfo;

    public String getPresentationLayerInfo() {
        return presentationLayerInfo;
    }

    public void setPresentationLayerInfo(String presentationLayerInfo) {
        this.presentationLayerInfo = presentationLayerInfo;
    }

    public String getBusinessLayerInfo() {
        return businessLayerInfo;
    }

    public void setBusinessLayerInfo(String businessLayerInfo) {
        this.businessLayerInfo = businessLayerInfo;
    }

    public String getDataAccessLayerInfo() {
        return dataAccessLayerInfo;
    }

    public void setDataAccessLayerInfo(String dataAccessLayerInfo) {
        this.dataAccessLayerInfo = dataAccessLayerInfo;
    }
}
