package com.nihi.bl.driver.model;

import lombok.Data;

@Data
public class DashboardResponse {

    private String statusCode;
    private String statusMessage;
    private Double earning;
    private Double inProgress;
    private Double complete;

    
}
