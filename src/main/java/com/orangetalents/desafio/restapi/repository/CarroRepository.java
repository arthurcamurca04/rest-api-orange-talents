package com.orangetalents.desafio.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents.desafio.restapi.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

}
