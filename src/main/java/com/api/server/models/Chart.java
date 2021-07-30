package com.api.server.models;

public class Chart {

    private Integer total;
    private String type;

    public Chart(Integer totalType, String name) {
        this.total = totalType;
        this.type = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
