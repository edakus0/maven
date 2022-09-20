package com.eda.backend.repository;


import com.eda.backend.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //Bu arayüzün proje için depo tanımlayacağını belirtir
public interface UserRepository extends JpaRepository<User, Long> {
    
    
}
