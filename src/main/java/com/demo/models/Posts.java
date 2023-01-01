package com.demo.models;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
public class Posts {

    private int id;
    private String firstname;
    private String lastname;
}
