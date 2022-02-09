package com.safeTravel.service.impl;

import com.safeTravel.dto.CommentDto;
import com.safeTravel.mapper.referentiel.CommentMapper;
import com.safeTravel.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl implements com.safeTravel.service.CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentDto> getAll() {
        log.info(commentRepository.findAll().toString());
        return commentMapper.toDtos(commentRepository.findAll());
    }

    @Override
    public CommentDto getById(Long id) {
        return commentMapper.toDto(commentRepository.getById(id));
    }

    @Override
    public CommentDto create(CommentDto dto) {
        return commentMapper.toDto(commentRepository.save(commentMapper.toEntity(dto)));
    }

    @Override
    public CommentDto update(CommentDto dto) {
        return commentMapper.toDto(commentRepository.save(commentMapper.toEntity(dto)));
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    public List<CommentDto> getCommentsByUserId(Long id) {
        return commentMapper.toDtos(commentRepository.getCommentsByUserId(id));
    }
}
