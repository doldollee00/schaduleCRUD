package org.example.memo.repository;

import org.example.memo.entity.Member;
import org.example.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface MemberRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrElseThrow(Long userId) {
        return findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + userId));
    }
}
