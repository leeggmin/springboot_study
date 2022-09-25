package com.example.whatisrice.repository;

import com.example.whatisrice.domain.Rice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaRiceRepository implements RiceRepository{

    private final EntityManager em;

    public JpaRiceRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public String findById(Long day) {
        Rice rice=em.find(Rice.class,day);
        return rice.getMenu();
    }
}
