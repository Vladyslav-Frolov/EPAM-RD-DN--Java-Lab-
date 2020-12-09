package com.epam.hw4.model;

 public interface Order extends Entity {
     Double getCostPerDay();

     void setCostPerDay(Double costPerDay);

     Integer getDays();

     void setDays(Integer days);

     String getRoomClass();

     void setRoomClass(String roomClass);

     String getRoomType();

     void setRoomType(String roomType);

     Integer getClientId();

     void setClientId(Integer clientId);

     Integer getRoomId();

     void setRoomId(Integer roomId);

     String getCheckIn();

     void setCheckIn(String checkIn);

     String getCheckOut();

     void setCheckOut(String checkOut);

     Double getTotalPrice();

     void setTotalPrice(Double totalPrice);

     Boolean getPaymentStatus();

     void setPaymentStatus(Boolean paymentStatus);

     String getStartBookingTime();

     void setStartBookingTime(String startBookingTime);

     RoomStatus getOrderStatus();

     void setOrderStatus(RoomStatus orderStatus);
}
