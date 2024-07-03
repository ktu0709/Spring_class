package repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.*;

public class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository  = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member res =  repository.findById(member.getId()).get();
		System.out.println("result = " + (res == member));
		//Assertions.assertEquals(res, member);
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		
		Member res =  repository.findByName("spring1").get();
		
		Assertions.assertEquals(res, member1);
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> res = repository.findAll();
		
		
		
	}

}
