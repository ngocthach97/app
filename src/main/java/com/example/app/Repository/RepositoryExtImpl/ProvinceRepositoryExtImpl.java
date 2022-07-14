package com.example.app.Repository.RepositoryExtImpl;

import com.example.app.Model.DTO.ProvinceDTO;
import com.example.app.Model.Entity.Province;
import com.example.app.Model.Mapper.ProvinceMapper;
import com.example.app.Repository.RepositoryExt.ProvinceRepositoryExt;
import com.example.app.Utility.Common.Request.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProvinceRepositoryExtImpl implements ProvinceRepositoryExt {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<ProvinceDTO> searchProvincePaging(Page page) {
        Pageable pageable = page.getPageable();
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Object> map = new HashMap<>();
        stringBuilder.append("SELECT d FROM province d");
        Query query = entityManager.createQuery(stringBuilder.toString());

        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
            query.setMaxResults(pageable.getPageSize());
        } else {
            query.setFirstResult(0);
            query.setMaxResults(20);
        }
        List<Province> list = query.getResultList();
        List<ProvinceDTO> listDTO = provinceMapper.toListEntityListDTO(list);

        return listDTO;
    }
}
