package com.safeTravel.service;

import com.safeTravel.dto.CommentDto;

import java.util.List;

public interface CommentService extends ServiceShared<CommentDto, Long> {
    List<CommentDto> getCommentsByUserId(Long id);
}
