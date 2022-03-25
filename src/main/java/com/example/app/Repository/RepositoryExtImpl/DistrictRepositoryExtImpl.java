package com.example.app.Repository.RepositoryExtImpl;

import com.example.app.Model.Entity.District;
import com.example.app.Model.Entity.Users;
import com.example.app.Repository.RepositoryExt.DistrictRepositoryExt;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistrictRepositoryExtImpl implements DistrictRepositoryExt {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<District> search() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> map = new HashMap<>();
        stringBuilder.append("SELECT d FROM district d");
        Query query = entityManager.createQuery(stringBuilder.toString());
        List<District> list = query.getResultList();
        return list;
    }
}
