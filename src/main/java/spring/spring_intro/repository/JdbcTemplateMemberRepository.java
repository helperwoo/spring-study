package spring.spring_intro.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spring.spring_intro.domain.Member;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class JdbcTemplateMemberRepository implements MemberRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        Member member = new Member();
        member.setName();
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        List<Member> result = this.jdbcTemplate.query("select * from member wher id = ?", memberRowMapper());

        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
//        return store.values().stream()
//                .filter(member ->  member.getName().equals(name))
//                .findAny();
    }

    @Override
    public List<Member> findAll() {
//        return new ArrayList<>(store.values());
        return new ArrayList<Member>();
    }

    public RowMapper<Member> memberRowMapper() {
        return ((rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            return member;
        });
    }
}
