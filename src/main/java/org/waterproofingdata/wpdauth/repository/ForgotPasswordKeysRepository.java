package org.waterproofingdata.wpdauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.waterproofingdata.wpdauth.model.ForgotPasswordKeys;

public interface ForgotPasswordKeysRepository extends JpaRepository<ForgotPasswordKeys, Integer> {
	@Query(value = "SELECT f.* FROM forgotpassword_keys f WHERE f.email = ?1 AND f.key = ?2 AND f.created_at >= current_date::timestamp AND f.created_at < current_date::timestamp + interval '1 day' ORDER BY f.id DESC LIMIT 1", nativeQuery = true)
	ForgotPasswordKeys findTodayRecordByEmailANDKey(String email, String key);
}
