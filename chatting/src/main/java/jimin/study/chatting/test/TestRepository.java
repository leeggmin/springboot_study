package jimin.study.chatting.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Member, Long> {
}
