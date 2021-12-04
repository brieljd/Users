package com.bci.users.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "PHONE")
public class Phone {

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID phoneId;
    private String number;
    private String citycode;
    private String countrycode;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;
}
