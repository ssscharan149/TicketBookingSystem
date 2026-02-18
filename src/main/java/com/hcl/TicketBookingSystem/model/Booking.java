package com.hcl.TicketBookingSystem.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int seatCount;
    private double totalFare;
    private String bookingStatus;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private TrainSchedule schedule;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Passenger> passengers;

    public Booking() {}

    // getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public int getSeatCount() { return seatCount; }

    public void setSeatCount(int seatCount) { this.seatCount = seatCount; }

    public double getTotalFare() { return totalFare; }

    public void setTotalFare(double totalFare) { this.totalFare = totalFare; }

    public String getBookingStatus() { return bookingStatus; }

    public void setBookingStatus(String bookingStatus) { this.bookingStatus = bookingStatus; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public TrainSchedule getSchedule() { return schedule; }

    public void setSchedule(TrainSchedule schedule) { this.schedule = schedule; }

    public List<Passenger> getPassengers() { return passengers; }

    public void setPassengers(List<Passenger> passengers) { this.passengers = passengers; }
}

