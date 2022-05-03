package com.example.whatisrice.service;

import com.example.whatisrice.domain.Date;
import com.example.whatisrice.repository.RiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RiceService {
    public final RiceRepository riceRepository;

    @Autowired
    public RiceService(RiceRepository riceRepository) {
        this.riceRepository = riceRepository;
    }

    public Optional<Date> findone(Long day){
        return riceRepository.findByDay(day);
    }
}
