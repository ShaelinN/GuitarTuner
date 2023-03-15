package com.shaelinn.guitartuner.services;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.shaelinn.guitartuner.api.models.Tuning;

@Service
public class TuningService {

    SessionFactory sessionFactory;

    public TuningService() {
        Configuration configuration = new GuitarTuningDBConfig();
        configuration.addAnnotatedClass(Tuning.class);
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public Tuning getTuning(String id) {
        return retrieveTuningFromDB(Integer.parseInt(id));
    }

    public Tuning addTuning(String name, String category, String subCategory, String notes) {
        Tuning tuning = new Tuning(name, category, subCategory, tuningFromString(notes));
        submitTuningToDB(tuning);
        return tuning;
    }

    public Tuning addTuning(String name, String category, String notes) {
        Tuning tuning = new Tuning(name, category, null, tuningFromString(notes));
        submitTuningToDB(tuning);
        return tuning;
    }

    private List<Integer> tuningFromString(String tuning) {
        return Arrays.asList(tuning.split(","))
        .stream().map(i -> Integer.parseInt(i)).toList();
    }

    void submitTuningToDB(Tuning tuning) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(tuning);
        session.getTransaction().commit();
        session.close();
    }

    Tuning retrieveTuningFromDB(int id) {
        Session session = sessionFactory.openSession();
        Query<Tuning> q = session.createNativeQuery("Select * from Tuning where id= :id", Tuning.class);
        q.setParameter("id", id);

        Tuning result = q.uniqueResult();
        session.close();
        return result;
    }

}
