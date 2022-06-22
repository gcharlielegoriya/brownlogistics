package com.nihi.bl.driver.model;

import lombok.Data;

@Data
public class DetailsRequest {

    private String frieghtId;

    public String getFrieghtId() {
        return frieghtId;
    }

    public void setFrieghtId(String frieghtId) {
        this.frieghtId = frieghtId;
    }

    @Override
    public String toString() {
        return "DetailsRequest{" +
                "frieghtId=" + frieghtId +
                '}';
    }
}
