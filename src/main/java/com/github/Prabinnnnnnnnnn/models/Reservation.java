package com.github.Prabinnnnnnnnnn.models;

import java.util.Date;

public class Reservation {
private Date dateReserved;
private ReservationPriority priority;
private Date dateFulfilled;

 public Reservation(Date dateReserved, ReservationPriority priority, Date dateFulfilled) {
     this.dateReserved = dateReserved;
     this.priority = priority;
     this.dateFulfilled = dateFulfilled;
 }

 public Date getDateReserved() {
     return dateReserved;
 }
 public void setDateReserved(Date dateReserved) {
     this.dateReserved = dateReserved;
 }
 public ReservationPriority getPriority() {
     return priority;
 }
 public void setPriority(ReservationPriority priority) {
     this.priority = priority;
 }
 public Date getDateFulfilled() {
     return dateFulfilled;
 }
 public void setDateFulfilled(Date dateFulfilled) {
     this.dateFulfilled = dateFulfilled;
 }
}
