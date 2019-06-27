package com.sk.sample.mssp.member.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.mssp.member.domain.model.Member;

@RepositoryRestResource
public interface MemberRepository extends PagingAndSortingRepository<Member, Long>,
                                           QueryDslPredicateExecutor<Member> {
	
	Member findByEmail(@Param("email") String email);
	Member findByUserId(@Param("userId") String userId);
	
	List<Member> findByNameLike(@Param("name") String name);
	List<Member> findAll();
	
	List<Member> findByAddressZipCode(@Param("zipCode") Integer zipCode);
	
	@Query("select a from Member a where a.address.homeAddress like %?1%")
	List<Member> findByAddressHomeAddressLike(@Param("homeAddress") String homeAddress);
	

	List<Member> findAll(Predicate predicate); 
	
}
