package com.ex_community.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Boolean enabled;

    @ManyToMany
    @JoinTable(
            name = "user_role", // 조인 테이블 명
            joinColumns = @JoinColumn(name = "user_id"), // 현재 엔티티(user)를 참조하는 외래키 (user_role 테이블의 user_id)
            inverseJoinColumns = @JoinColumn(name = "role_id")) // 반대 엔티티(role)를 참조하는 외래키 (user_role 테이블의 role_id)
    private List<Role> roles = new ArrayList<>();


    /* 사용자 조회 시, 작성한 게시글 조회 가능 */
    /* 현재 Board와 User은 양방향 mapping */
    @OneToMany(mappedBy = "user") // user 변수에 정의해 뒀던 것을 동일하게 사용한다는 뜻
    private List<Board> boards = new ArrayList<>();



}