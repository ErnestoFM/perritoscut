package com.cut.cardona.modelo.perros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface RepositorioPerro extends JpaRepository<Perro,Long> {


}
