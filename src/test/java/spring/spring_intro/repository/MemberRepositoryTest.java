package spring.spring_intro.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.spring_intro.domain.Member;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional
class MemberRepositoryTest {
    @Autowired private MemberRepository memberRepository;

    @Test
    public void save() {
        Member member1 = new Member();
        member1.setName("홍길동");

        memberRepository.save(member1);

        Member member2 = memberRepository.findById(member1.getId()).get();
        assertThat(member1.getId()).isEqualTo(member2.getId());
    }
}
