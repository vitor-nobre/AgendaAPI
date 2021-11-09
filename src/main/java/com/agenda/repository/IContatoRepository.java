package com.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.agenda.model.Contato;

public interface IContatoRepository extends JpaRepository<Contato, Integer>, JpaSpecificationExecutor<Contato> {

}
