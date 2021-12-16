package com.ex_community.model;

import lombok.Data;

import javax.persistence.*;
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


    /* 현재 Board와 User은 양방향 mapping */
    @ManyToOne
    @JoinColumn(name = "user_id")
    /* name = 어떤 컬럼과 user table이 연결이 될 지 설정 */
    /* referencedColumnName = 사용자 table 어떤 컬럼과 연결되어 있는지 */
    /* referencedColumnName의 경우 @ID인 pk 값으로 지정되어 있으면 생략해도 괜찮다*/
    private User user;


}
