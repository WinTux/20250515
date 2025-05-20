package com.pepe.consum.Repositorios;

import com.pepe.consum.Models.RegistroWikimedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<RegistroWikimedia,Long> {
}
