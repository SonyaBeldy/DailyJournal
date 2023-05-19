package ru.sonyabeldy.dailyjournal.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.sonyabeldy.dailyjournal.models.Timer;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class TimerDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public TimerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public void save(Timer timer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(timer);

        List<Timer> timers = session.createQuery("select p from Timer p", Timer.class).getResultList();
    }

    @Transactional
    public void addEndTime(Timer timer) {
        Session session = sessionFactory.getCurrentSession();

//        Timer timer = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
//        session.merge(timer);
        session.persist(timer);

    }
}
