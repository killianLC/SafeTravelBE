package com.safeTravel.service;

import com.safeTravel.dto.CommentDto;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CommentService extends ServiceShared<CommentDto, Long> {
    List<CommentDto> getAll();
}
