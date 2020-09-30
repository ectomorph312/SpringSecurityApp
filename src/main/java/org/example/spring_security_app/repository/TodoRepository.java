package org.example.spring_security_app.repository;

import org.example.spring_security_app.entity.Todo;
import org.example.spring_security_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllById(User user);
    List<Todo> findAllByCompletedIsLessThanEqual(LocalDateTime completed);
}
