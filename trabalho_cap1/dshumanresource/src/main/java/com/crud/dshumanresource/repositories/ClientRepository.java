package com.crud.dshumanresource.repositories;

import org.springframework.stereotype.Repository;

import com.crud.dshumanresource.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
