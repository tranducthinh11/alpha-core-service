package vn.alphabank.repository;

import java.util.Optional;

import vn.alphabank.domain.Group;

/**
 * Spring Data MongoDB repository for the {@link Authority} entity.
 */
//@Repository
public interface AuthorityRepository  {
    Optional<Group> findByName(String login);
}
