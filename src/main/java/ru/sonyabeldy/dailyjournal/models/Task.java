package ru.sonyabeldy.dailyjournal.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;



}
