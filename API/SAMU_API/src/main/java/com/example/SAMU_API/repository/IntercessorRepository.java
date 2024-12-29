package com.example.SAMU_API.repository;

import com.example.SAMU_API.domain.intercessor.Intercessor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IntercessorRepository extends JpaRepository<Intercessor, Long> {
    Intercessor getReferenceByIdAndAtivoTrue(Long aLong);

    List<Intercessor> findAllByAtivoTrue();
}
