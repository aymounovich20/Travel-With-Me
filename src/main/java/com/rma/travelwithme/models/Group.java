package com.rma.travelwithme.models;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    private String groupName;

    @ManyToOne
    @JoinColumn(name = "group_leader_id")
    private User groupLeader;

    private LocalDateTime createdDate;

    // Getters and setters

    // You can add additional constructors and methods as needed
}

