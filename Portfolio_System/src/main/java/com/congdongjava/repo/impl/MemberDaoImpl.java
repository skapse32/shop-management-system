package com.congdongjava.repo.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.congdongjava.domain.Member;
import com.congdongjava.repo.MemberDao;

@Repository
@Transactional
public class MemberDaoImpl extends AbstractBaseDao implements MemberDao
{
    public Member findById(final Long id)
    {
        return em.find(Member.class, id);
    }

    public Member findByEmail(final String email)
    {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteria = builder.createQuery(Member.class);
        Root<Member> member = criteria.from(Member.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(member).where(builder.equal(member.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Member> findAllOrderedByName()
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
        Root<Member> member = criteria.from(Member.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(member).orderBy(cb.asc(member.get("name")));
        return em.createQuery(criteria).getResultList();
    }

    public void create(final Member member)
    {
        em.persist(member);
        return;
    }

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAllWithPaging(final int startPage, final int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(final Member entity) {
		em.merge(entity);
	}

	@Override
	public void deleteById(final Long id) {
		// TODO Auto-generated method stub
		
	}
}
