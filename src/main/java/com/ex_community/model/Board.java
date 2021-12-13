package com.ex_community.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 위해 설정
    private Long id;

    @NotNull
    @Size(min=2, max=30, message = "제목은 2자 이상 30자 이하로 입력하실 수 있습니다.")
    private String title;
    private String content;
}
