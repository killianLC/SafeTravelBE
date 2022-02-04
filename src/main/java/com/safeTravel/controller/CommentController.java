package com.safeTravel.controller;

import com.safeTravel.dto.CityDto;
import com.safeTravel.dto.CommentDto;
import com.safeTravel.service.CommentService;
import com.safeTravel.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/comment"})
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping({"/all"})
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getAll() {
        List<CommentDto> comments = commentService.getAll();
        return comments;
    }
}
