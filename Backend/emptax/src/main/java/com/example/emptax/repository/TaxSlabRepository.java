package com.example.emptax.repository;

import com.example.emptax.model.TaxSlab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxSlabRepository extends JpaRepository<TaxSlab, Long> {
}
