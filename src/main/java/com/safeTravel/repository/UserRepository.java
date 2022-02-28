package com.safeTravel.repository;

import com.safeTravel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    boolean existsByEmail(String email);

    @Modifying
    @Query(value="UPDATE user SET user.firstname = :firstname, user.lastname = :lastname WHERE user.id = :id", nativeQuery = true)
    void queryUpdateFirstnameAndLastnameById(@Param(value = "firstname") String firstname, @Param(value= "lastname") String lastname, @Param(value= "id") Long id);

    @Modifying
    @Query(value="UPDATE user SET user.password = :password WHERE user.id = :id", nativeQuery = true)
    void queryUpdatePasswordById(@Param(value = "password") String password, @Param(value= "id") Long id);
}