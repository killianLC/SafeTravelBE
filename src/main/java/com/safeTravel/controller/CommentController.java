package com.safeTravel.controller;

import com.safeTravel.dto.CommentDto;
import com.safeTravel.service.impl.CommentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/comment"})
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping({"/all"})
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getAll() {
        List<CommentDto> comments = commentService.getAll();
        return comments;
    }

    @GetMapping({"/user/{user_id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getCommentsByUserId(@PathVariable("user_id") Long user_id) {
        List<CommentDto> comments = commentService.getCommentsByUserId(user_id);
        logger.debug("Comment, getCommentsByUserId() :{}", user_id);
        return comments;
    }
}
