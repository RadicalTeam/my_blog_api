package com.data.postgres.my_blog_api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @Column(unique = true)
    private String location;

    private boolean published = false;

    private String brief;

    @Column(name = "view_time")
    private Integer viewTime = 0;

    private String commons;

    @Column(updatable = false)
    private Date createAt;

    private Date updateAt;

}
