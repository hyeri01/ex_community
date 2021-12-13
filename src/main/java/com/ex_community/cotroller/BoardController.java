package com.ex_community.cotroller;

import com.ex_community.model.Board;
import com.ex_community.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model){
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("board", new Board());
        return "board/form";
    }

    @PostMapping("/form")
    public String fromSubmit(@ModelAttribute Board board){
        boardRepository.save(board); // save == insert
        // save == id의 key 값이 있을 경우에는 update가, 없는 경우에는 insert

        return "redirect:/board/list";
    }
}
