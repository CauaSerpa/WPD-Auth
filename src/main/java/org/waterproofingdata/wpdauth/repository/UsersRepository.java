package org.waterproofingdata.wpdauth.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.waterproofingdata.wpdauth.model.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {
	  boolean existsByUsername(String username);

	  Users findByUsername(String username);
	  
	  boolean existsByEmail(String email);
	  
	  Users findByEmail(String email);

	  @Transactional
	  @Query(value = "UPDATE auth.users SET active = ?2 WHERE username = ?1", nativeQuery = true)
	  void activateByUsername(String username, Integer active);
}
