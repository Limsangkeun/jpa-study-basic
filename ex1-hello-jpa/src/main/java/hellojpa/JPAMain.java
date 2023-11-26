package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*
                //insert
                Member m = new Member();
                m.setId(1L);
                m.setName("test");
                em.persist(m);

                //select
                Member m = em.find(Member.class, 1L);

                //select list(using JPQL)
                List<Member> resultList = em.createQuery("select m from Member as m", Member.class).getResultList();
                for (Member member : resultList) {
                    System.out.println("member : " + member.getName());
                }

                //update
                Member m = em.find(Member.class, 1L);
                m.setName("test2");

                //delete
                Member m = em.find(Member.class, 1L);
                em.remove(m);
             */

            // 비영속
            Member m = new Member();
            m.setId(1L);
            m.setName("test");

            // 영속(DB 쿼리 나가는 시기 X, 트랜잭션 커밋 시점에 쿼리 실행)
            em.persist(m);

            // 준영속
            em.detach(m);

            // 삭제
            em.remove(m);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
