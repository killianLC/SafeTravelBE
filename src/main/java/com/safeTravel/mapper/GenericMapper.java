package com.safeTravel.mapper;

import java.util.List;

public interface GenericMapper <E, D>{
    D toDto(E e);
    E toEntity(D d);
    List<D> toDtos(List<E> e);
    List<E> toEntity(List<D> d);
}
