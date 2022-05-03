package com.example.whatisrice.repository;

import com.example.whatisrice.domain.Date;

import java.util.Optional;

public interface RiceRepository {
    Optional<Date> findByDay(Long day);
}
