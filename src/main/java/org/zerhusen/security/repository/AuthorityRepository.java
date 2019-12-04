package org.zerhusen.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.zerhusen.eniity.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
