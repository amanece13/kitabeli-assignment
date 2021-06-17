package com.kitabeli.application.respository;

import com.kitabeli.application.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealsRepository extends JpaRepository<Deal, Long> {
}
