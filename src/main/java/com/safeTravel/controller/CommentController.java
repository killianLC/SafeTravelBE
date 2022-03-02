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
@RequestMapping({"/comments"})
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getAll() {
        return commentService.getAll();
    }

    /**
     * Endpoint /comments/{id} type GET
     *
     * @return CommentDto found thanks to his id
     */
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.FOUND)
    public CommentDto getById(@PathVariable("id") Long id) {
        return commentService.getById(id);
    }

    @GetMapping({"/user/{user_id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getCommentsByUserId(@PathVariable("user_id") Long user_id) {
        List<CommentDto> comments = commentService.getCommentsByUserId(user_id);
        logger.debug("Comment, getCommentsByUserId() :{}", user_id);
        return comments;
    }

    /**
     * Endpoint /comments type POST
     *
     * @return CommentDto created
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(@RequestBody CommentDto commentDto) {
        return this.commentService.create(commentDto);
    }

    /**
     * Endpoint /comments type PUT
     *
     * @return CommentDto updated
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CommentDto update(@RequestBody CommentDto commentDto) {
        return this.commentService.update(commentDto);
    }

    /**
     * Endpoint /comments/{id} type DELETE
     *
     * @param id id of the deleted comment
     */
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        this.commentService.deleteById(id);
    }
}
