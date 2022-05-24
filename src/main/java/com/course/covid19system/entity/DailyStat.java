package com.course.covid19system.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "daily_stats")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DailyStat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "total_cases")
    private int total_cases;

    @Column(name = "new_cases")
    private int new_cases;

    @Column(name = "total_deaths")
    private int total_deaths;

    @Column(name = "new_deaths")
    private int new_deaths;

    @Column(name = "total_recovered")
    private int total_recovered;

    @Column(name = "total_tests")
    private int total_tests;

    @Column(name = "new_tests")
    private int new_tests;

    @Column(name = "people_vaccinated")
    private int people_vaccinated;

    @Column(name = "new_vaccinations")
    private int new_vaccinations;
}
