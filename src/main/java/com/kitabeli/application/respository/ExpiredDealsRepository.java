package com.kitabeli.application.respository;

import com.kitabeli.application.entity.ExpiredDeals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpiredDealsRepository extends JpaRepository<ExpiredDeals, Long> {
}
