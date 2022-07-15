package com.example.springtest.data.db.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private Long countryId;
    private Long typeId;

    @ManyToOne
    @JoinColumn(name="countryId",insertable = false,updatable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name="typeId",insertable = false,updatable = false)
    private Type type;
}
