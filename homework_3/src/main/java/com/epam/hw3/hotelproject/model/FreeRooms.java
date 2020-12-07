package com.epam.hw3.hotelproject.model;

import org.springframework.stereotype.Component;

@Component
public class FreeRooms extends EntityImpl {

    private String roomType;//
    private String roomClass;//++++++++++++
    private Integer numberOfPeople;
    private Integer numberOfAdults;//++++++++++++
    private Integer numberOfChildren;//++++++++++++
    private Integer daysOfStay;//++++++++++++
    private Double costPerDay;//++++++++++++
    private Double totalPrice;//

    public FreeRooms() {
    }


    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Integer getDaysOfStay() {
        return daysOfStay;
    }

    public void setDaysOfStay(Integer daysOfStay) {
        this.daysOfStay = daysOfStay;
    }

    public Double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "FreeRooms{" +
                "room number=" + super.getId() + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomClass='" + roomClass + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", numberOfAdults=" + numberOfAdults +
                ", numberOfChildren=" + numberOfChildren +
                ", daysOfStay=" + daysOfStay +
                ", costPerDay=" + costPerDay +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
