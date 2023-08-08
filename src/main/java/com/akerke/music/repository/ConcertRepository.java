package com.akerke.music.repository;

import com.akerke.music.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
}
