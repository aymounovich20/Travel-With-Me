package com.rma.travelwithme.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rma.travelwithme.services.GroupService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;
    //private Double costPerPerson;
    private String description;
    private Long totalDays = GroupService.calculateDaysBetween(this.startDate, this.endDate);
    @ManyToOne
    @JoinColumn(name = "group_leader_id")
    private User groupLeader;

    @ElementCollection
    private Set<String> listOfJoinersEmails;
    @OneToMany
    @JoinColumn(name = "list_of_joiners")
    List<Invitation> listOfJoiners;

    //private LocalDateTime createdDate;
}

