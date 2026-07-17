package com.example.shareapp.repository;

import com.example.shareapp.model.ClickLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickLogRepository extends JpaRepository<ClickLog, Long> {
}
