package com.example.app.Repository.RepositoryExtImpl;

import com.example.app.Model.Entity.District;
import com.example.app.Model.Entity.Province;
import com.example.app.Repository.RepositoryExt.ProvinceRepositoryExt;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProvinceRepositoryExtImpl implements ProvinceRepositoryExt {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Province> search() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> map = new HashMap<>();
        stringBuilder.append("SELECT d FROM province d");
        Query query = entityManager.createQuery(stringBuilder.toString());
        List<Province> list = query.getResultList();
        return list;
    }
}
