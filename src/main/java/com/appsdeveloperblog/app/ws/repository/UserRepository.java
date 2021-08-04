package com.appsdeveloperblog.app.ws.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
    UserEntity findByUserId(String userId);
    UserEntity findUserByEmailVerificationToken(String token);

    @Query(value="select * from Users u where u.EMAIL_VERIFICATION_STATUS = 'true'",
            countQuery="select count(*) from Users u where u.EMAIL_VERIFICATION_STATUS = 'true'",
            nativeQuery = true)
    Page<UserEntity> findAllUsersWithConfirmedEmailAddress(Pageable pageableRequest );

    @Query(value="select * from Users u where u.first_name = ?1",nativeQuery=true)
    List<UserEntity> findUserByFirstName(String firstName);

    @Query(value="select * from Users u where u.last_name = :lastName",nativeQuery=true)
    List<UserEntity> findUserByLastName(@Param("lastName") String lastName);

    @Query(value="select * from Users u where first_name LIKE %:keyword% or last_name LIKE %:keyword%",nativeQuery=true)
    List<UserEntity> findUsersByKeyword(@Param("keyword") String keyword);

    @Query(value="select u.first_name, u.last_name from Users u where u.first_name LIKE %:keyword% or u.last_name LIKE %:keyword%",nativeQuery=true)
    List<Object[]> findUserFirstNameAndLastNameByKeyword(@Param("keyword") String keyword);

}
