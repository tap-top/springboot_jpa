package com.boe.tww.jpa;

import com.boe.tww.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerJPA
extends JpaRepository<LoggerEntity,Long>{
}
