package com.prabhattechtest.springboot.model;

public class DailySummary {

    private String Client_Information;

    private String Product_Information;

    private String Total_Transaction_Amount;

    public DailySummary(String client_Information, String product_Information, String total_Transaction_Amount) {
        Client_Information = client_Information;
        Product_Information = product_Information;
        Total_Transaction_Amount = total_Transaction_Amount;
    }

    public String getClient_Information() {
        return Client_Information;
    }

    public void setClient_Information(String client_Information) {
        Client_Information = client_Information;
    }

    public String getProduct_Information() {
        return Product_Information;
    }

    public void setProduct_Information(String product_Information) {
        Product_Information = product_Information;
    }

    public String getTotal_Transaction_Amount() {
        return Total_Transaction_Amount;
    }

    public void setTotal_Transaction_Amount(String total_Transaction_Amount) {
        Total_Transaction_Amount = total_Transaction_Amount;
    }

    @Override
    public String toString() {
        return Client_Information + ',' +Product_Information + ',' +Total_Transaction_Amount;
    }
}
