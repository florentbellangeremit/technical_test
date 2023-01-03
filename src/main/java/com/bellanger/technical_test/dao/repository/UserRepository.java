package com.bellanger.technical_test.dao.repository;

import com.bellanger.technical_test.dao.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM USR WHERE username=:username and birthdate=:birthdate and country=:country", nativeQuery = true)
    Optional<User> findByUsernameAndBirthdateAndCountry(@Param("username") String username,
                                                        @Param("birthdate") Timestamp birthdate,
                                                        @Param("country") String country);
}
