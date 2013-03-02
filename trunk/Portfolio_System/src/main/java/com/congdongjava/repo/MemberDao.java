package com.congdongjava.repo;

import java.util.List;

import com.congdongjava.domain.Member;

public interface MemberDao extends BaseDao<Long, Member>{
    public Member findByEmail(final String email);

    public List<Member> findAllOrderedByName();
}
