package com.epam.hw2.hotelproject.model;

public class Order extends Entity{
    private Integer clientId;
    private Integer roomId;
    private String roomType;
    private String roomClass;
    private String checkIn;
    private String checkOut;
    private Integer days;
    private Double costPerDay;
    private Double totalPrice;
    private Boolean paymentStatus;
    private String startBookingTime;
    private RoomStatus orderStatus;

    public Double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getStartBookingTime() {
        return startBookingTime;
    }

    public void setStartBookingTime(String startBookingTime) {
        this.startBookingTime = startBookingTime;
    }

    public RoomStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(RoomStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order id=" + super.getId() + '\'' +
                ", clientId=" + clientId +
                ", roomId=" + roomId +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", totalPrice=" + totalPrice +
                ", paymentStatus=" + paymentStatus +
                ", startBookingTime='" + startBookingTime + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
