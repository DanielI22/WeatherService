package com.example.springtest.data.db.Repository;

import com.example.springtest.data.db.Entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    boolean existsByTypeName(String name);
    Type findByTypeName(String name);
}
