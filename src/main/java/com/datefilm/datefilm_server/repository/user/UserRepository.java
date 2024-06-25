package com.datefilm.datefilm_server.repository.user;

import com.datefilm.datefilm_server.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>, UserRepositoryCustom {

    Optional<User> findById(Long userId);


}