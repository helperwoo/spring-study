package spring.spring_intro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring_intro.repository.JdbcTemplateMemberRepository;
import spring.spring_intro.repository.JpaMemberRepository;
import spring.spring_intro.repository.MemberRepository;
import spring.spring_intro.repository.MemoryMemberRepository;
import spring.spring_intro.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//    private final DataSource dataSource;

//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
