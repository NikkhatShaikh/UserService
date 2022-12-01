package com.nikkhat.user.service.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Table(name ="userService")
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "id")
    private String userId;

    @Column(name = "name",length = 30)
    private String name;

    @Column(name ="email")
    private String email;

    @Column(name = "about")
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();



}
