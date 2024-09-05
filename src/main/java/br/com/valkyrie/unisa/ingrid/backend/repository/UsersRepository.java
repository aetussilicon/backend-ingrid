package br.com.valkyrie.unisa.ingrid.backend.repository;

import br.com.valkyrie.unisa.ingrid.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
}
