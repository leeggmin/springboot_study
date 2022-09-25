package com.example.whatisrice.service;

import com.example.whatisrice.domain.Rice;
import com.example.whatisrice.repository.RiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiceService {

    public final RiceRepository riceRepository;

    @Autowired
    public RiceService(RiceRepository riceRepository) {
        this.riceRepository = riceRepository;
    }

    public String findMenu(Rice rice){
        return riceRepository.findById(rice.getDay());
    }
}
