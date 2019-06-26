package com.sk.sample.mssp.member.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.mssp.member.domain.model.Member;
import com.sk.sample.mssp.member.domain.repository.MemberRepository;

@Service("memberLogic")
public class MemberLogic implements MemberService {
	@Autowired
	private MemberRepository memberRepository;

	@Override
	@Transactional(readOnly=true)
	public Member findById(Long id) {
		return memberRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Member> findByNameLike(String name) {
		return memberRepository.findByNameLike(name);
	}

	@Override
	@Transactional(readOnly=true)
	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Member> findAll(Pageable pageable) {
		return memberRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Member register(Member member) {
		return memberRepository.save(member);
	}

	@Override
	@Transactional
	public Member update(Long id, Member newAccount) {
		Member oldAccount = memberRepository.findOne(id);
		if(oldAccount != null) {
			BeanUtils.copyProperties(newAccount,  oldAccount, "id");
			return memberRepository.save(oldAccount);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		memberRepository.delete(id);
	}
}
