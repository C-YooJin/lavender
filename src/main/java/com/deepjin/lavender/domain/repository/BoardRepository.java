package com.deepjin.lavender.domain.repository;

import com.deepjin.lavender.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
