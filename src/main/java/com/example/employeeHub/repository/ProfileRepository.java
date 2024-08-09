package com.example.employeeHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employeeHub.entity.ProfileEntity;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    // Custom query to select only the IDs of all profiles
    @Query("SELECT p.id FROM ProfileEntity p")
    List<Long> findAllEIds();
    
    @Query("SELECT DISTINCT p.managerId FROM ProfileEntity p")
    List<Long> findAllMIds();
    
    // Custom query to select IDs of profiles where managerId matches the given id
    @Query("SELECT p.id FROM ProfileEntity p WHERE p.managerId = :managerId")
    List<Long> getEByManager(@Param("managerId") Long managerId);

	Optional<ProfileEntity> findByEmail(String email);
	
	 @Query("SELECT p.password FROM ProfileEntity p WHERE p.email = :email")
	String findPasswordByEmail(@Param("email") String email);
    
    


}

