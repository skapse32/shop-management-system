package com.congdongjava.repo.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.congdongjava.domain.Member;
import com.congdongjava.domain.Video;
import com.congdongjava.repo.VideoDao;

@Repository
@Transactional
public class VideoDaoImpl extends AbstractBaseDao implements VideoDao {

	@Override
	public Video findById(final Long id) {
		return em.find(Video.class, id);
	}
	
	private List<Video> findVideos(final boolean isAll, final int startPage, final int pageSize){
		final TypedQuery<Video> query = em.createNamedQuery("Video.findAll", Video.class);
		if(!isAll){
			query.setFirstResult(startPage*pageSize);
			query.setMaxResults(pageSize);
		}
		return query.getResultList();
	}

	@Override
	public List<Video> findAll() {
		return findVideos(Boolean.TRUE, -1, -1);
	}

	@Override
	public List<Video> findAllWithPaging(final int startPage, final int pageSize) {
		return findVideos(Boolean.FALSE, startPage, pageSize);
	}

	@Override
	public void create(final Video entity) {
		em.persist(entity);
	}

	@Override
	public void update(final Video entity) {
		em.merge(entity);
	}

	@Override
	public void deleteById(final Long id) {
		em.remove(findById(id));
	}

	@Override
	public List<Video> findByName(final String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Video> criteria = builder.createQuery(Video.class);
        Root<Video> video = criteria.from(Video.class);
        EntityType<Video> type = em.getMetamodel().entity(Video.class);
        //
        criteria.select(video).where(builder.like(video.get(type.getDeclaredSingularAttribute("name", String.class)), name));
        return em.createQuery(criteria).getResultList();
	}

	@Override
	public Video findByCode(final String code) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Video> criteria = builder.createQuery(Video.class);
		Root<Video> video = criteria.from(Video.class);
		//
		criteria.select(video).where(builder.equal(video.get("code"), code));
		return em.createQuery(criteria).getSingleResult();
	}

	@Override
	public List<Video> findAllOrderedByDate() {
		 CriteriaBuilder cb = em.getCriteriaBuilder();
         CriteriaQuery<Video> criteria = cb.createQuery(Video.class);
         Root<Video> video = criteria.from(Video.class);

	     /*
	     * Swap criteria statements if you would like to try out type-safe criteria queries, a new
	     * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
	     */

         criteria.select(video).orderBy(cb.desc(video.get("creationDate")));
         return em.createQuery(criteria).getResultList();
	}

}
