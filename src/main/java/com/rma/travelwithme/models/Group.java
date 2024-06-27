package com.rma.travelwithme.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.time.LocalDateTime;

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

    private String name;
    private String destination;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date startDate;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date endDate;
    //private Double costPerPerson;
    private String description;
	@ManyToOne
    @JoinColumn(name = "group_leader_id")
    private User groupLeader;

    //private LocalDateTime createdDate;
}

