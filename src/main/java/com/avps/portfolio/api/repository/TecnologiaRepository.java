package com.avps.portfolio.api.repository;

import com.avps.portfolio.api.domain.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long>, JpaSpecificationExecutor<Tecnologia> {

}
