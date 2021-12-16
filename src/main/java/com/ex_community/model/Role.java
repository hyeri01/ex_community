package com.ex_community.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles") // User 클래스의 컬럼 이름
    @JsonIgnore /* role을 가지고 있는 사용자들은 표시가 되지 않게 됨*/
    private List<User> users;
}

