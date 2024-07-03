package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;

class MemberServiceTest {

	MemoryMemberRepository memberRepository;
	MemberService memberService;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository); 
	}
	
	
	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void testJoin() {
		//given
		Member member = new Member();
		member.setName("spring");				
		
		//when
		Long saveId = memberService.join(member);
		
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());		
	}
	
	
	@Test
	void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		//when
		memberService.join(member1);
		IllegalStateException e =  assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		/*
		try {
			memberService.join(member2);
			fail();
		}catch(IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		}
		*/
				
		//then
	}

	@Test
	void testFindMembers() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFindOne() {
		fail("Not yet implemented"); // TODO
	}

}
