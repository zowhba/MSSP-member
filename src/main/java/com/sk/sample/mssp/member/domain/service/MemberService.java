package com.sk.sample.mssp.member.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.sample.mssp.member.domain.model.Member;

public interface MemberService {
	Member findById(Long id);
	List<Member> findAll();
	Page<Member> findAll(Pageable pageable);
	
	List<Member> findByNameLike(String name);
	Member findByEmail(String email);
	
	Member register(Member member);
	Member update(Long id, Member member);

	void delete(Long id);
}
