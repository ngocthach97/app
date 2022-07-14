package com.example.app.Repository.RepositoryExtImpl;

import com.example.app.Model.Entity.Users;
import com.example.app.Repository.RepositoryExt.UserRepositoryExt;
import com.example.app.Utility.Common.Request.Search;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryExtImpl implements UserRepositoryExt {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Users> search(Search search) {
        Pageable pageable = search.getPageable();
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> map = new HashMap<>();
        stringBuilder.append("SELECT u FROM users u ");
        stringBuilder.append("WHERE 1 = 1 ");
        if (search.getProvinceCode() != null) {
            stringBuilder.append("AND u.provinceCode = :provinceCode ");
            map.put("provinceCode", search.getProvinceCode());
        }
        if (search.getDistrictCode() != null) {
            stringBuilder.append("AND u.districtCode = :districtCode ");
            map.put("districtCode", search.getDistrictCode());
        }
        if (search.getWardCode() != null) {
            stringBuilder.append("AND u.wardCode = :wardCode");
            map.put("wardCode", search.getWardCode());
        }
        Query query = entityManager.createQuery(stringBuilder.toString());
        map.forEach(query::setParameter);

        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
            query.setMaxResults(pageable.getPageSize());
        } else {
            query.setFirstResult(0);
            query.setMaxResults(20);
        }
        List<Users> list = query.getResultList();
        return list;
    }
}
