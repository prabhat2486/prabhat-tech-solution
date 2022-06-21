package com.prabhattechtest.springboot.model;

import java.util.Objects;

public class Client {

    private String clientType;

    private String clientNumber;

    private String accountNumber;

    private String subAccountNumber;

    public Client(String clientType, String clientNumber, String accountNumber, String subAccountNumber) {
        this.clientType = clientType;
        this.clientNumber = clientNumber;
        this.accountNumber = accountNumber;
        this.subAccountNumber = subAccountNumber;
    }


    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSubAccountNumber() {
        return subAccountNumber;
    }

    public void setSubAccountNumber(String subAccountNumber) {
        this.subAccountNumber = subAccountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientType, client.clientType) &&
                Objects.equals(clientNumber, client.clientNumber) &&
                Objects.equals(accountNumber, client.accountNumber) &&
                Objects.equals(subAccountNumber, client.subAccountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientType, clientNumber, accountNumber, subAccountNumber);
    }

    @Override
    public String toString() {
        return clientType + clientNumber + accountNumber +subAccountNumber;
    }
}
