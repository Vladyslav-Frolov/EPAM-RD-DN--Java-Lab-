package com.epam.hw3.model;

public class Client extends User {
    Integer clientId;
    String record;
    String note;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId + '\'' +
                ", user id=" + super.getId() + '\'' +
                ", login='" + super.getLogin() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", createTime='" + super.getCreateTime() + '\'' +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", role=" + super.getRole() +
                ", record='" + record + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
