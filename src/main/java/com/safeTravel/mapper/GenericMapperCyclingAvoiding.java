package com.safeTravel.mapper;

import java.util.List;

import org.mapstruct.Context;

public interface GenericMapperCyclingAvoiding<E, D> {

    @DoIgnore
    default D toDto(E e) {
        return toDto(e, new CycleAvoidingMappingContext());
    }

    @DoIgnore
    default E toEntity(D d) {
        return toEntity(d, new CycleAvoidingMappingContext());
    }

    @DoIgnore
    default List<D> toDtos(List<E> e) {
        return toDtos(e, new CycleAvoidingMappingContext());
    }

    @DoIgnore
    default List<E> toEntities(List<D> d) {
        return toEntities(d, new CycleAvoidingMappingContext());
    }

    D toDto(E e, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    E toEntity(D d, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    List<D> toDtos(List<E> e, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    List<E> toEntities(List<D> d, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

}