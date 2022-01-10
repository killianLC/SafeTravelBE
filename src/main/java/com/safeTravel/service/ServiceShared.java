package com.safeTravel.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ServiceShared<A, T> {

    /**
     * Get all records
     *
     * @return records
     */
    List<A> getAll();

    /**
     * Get a record by id
     *
     * @param id to use to get the record
     * @return the record
     */
    A getById(T id);

    /**
     * Create a record
     *
     * @param dto record to create
     * @return record created
     */
    A create(A dto);

    /**
     * Update a record
     *
     * @param dto to use to update an existing record
     * @return record updated
     */
    A update(A dto);

    /**
     * Delete a record by the given id
     *
     * @param id of the record to delete
     */
    void deleteById(T id);

}