package com.course.covid19system.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "regions_info")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "population")
    private int population;

    @Column(name = "infections")
    private int infections;

    @Column(name = "info")
    private String info;

    @Column(name = "img_url")
    private String img_url;
}
