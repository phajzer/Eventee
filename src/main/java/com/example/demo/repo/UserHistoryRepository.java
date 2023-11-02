package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
