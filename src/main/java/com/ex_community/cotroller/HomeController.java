package com.ex_community.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // 가장 기본이 되는 첫 페이지는 경로 적지 않아도 접속 가능
    public String index(){
        return "index";
    }

}
