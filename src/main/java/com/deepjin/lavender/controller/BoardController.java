package com.deepjin.lavender.controller;

import com.deepjin.lavender.dto.BoardDto;
import com.deepjin.lavender.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class BoardController {

    private MyService myService;

    public BoardController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardDtoList = myService.getBoardList();
        model.addAttribute("postList", boardDtoList);

        return "board/list.html";
    }

    @GetMapping("/post")
    public String post() {
        return "board/post.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        myService.savePost(boardDto);

        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        BoardDto boardDto = myService.getPost(id);
        model.addAttribute("post", boardDto);

        return "board/detail.html";
    }

    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        BoardDto boardDto = myService.getPost(id);
        model.addAttribute("post", boardDto);
        return "board/edit.html";
    }

    @PutMapping("/post/edit/{id}")
    public String update(BoardDto boardDto) {
        myService.savePost(boardDto);

        return "redirect:/";
    }


}
