package com.ex_community.cotroller;

import com.ex_community.model.Board;
import com.ex_community.repository.BoardRepository;
import com.ex_community.validator.BoardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardValidator boardValidator;

    @GetMapping("/list")
    public String list(Model model){
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        // required 설정 이유 => 필요한 경우에만 받기 위해

        if (id == null){
            model.addAttribute("board", new Board());
        }else{
            Board board = boardRepository.findById(id).orElse(null);
            // key 값을 기준으로 조회 || orElse => 값이 없을 경우 null로
            model.addAttribute("board", board); // 값이 있는 경우
        }
        return "board/form";
    }

    @PostMapping("/form")
    public String fromSubmit(@Valid Board board, BindingResult bindingResult){
        boardValidator.validate(board, bindingResult);
        if(bindingResult.hasErrors()){
            return "board/form";
        }
        boardRepository.save(board); // save == insert
        // save == id의 key 값이 있을 경우에는 update가, 없는 경우에는 insert

        return "redirect:/board/list";
    }
}
