package com.currencyApplication.currencyApplication.repository;

import com.currencyApplication.currencyApplication.entity.ConversionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory,Long> {
}
