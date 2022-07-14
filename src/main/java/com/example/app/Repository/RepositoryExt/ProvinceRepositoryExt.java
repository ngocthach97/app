package com.example.app.Repository.RepositoryExt;

import com.example.app.Model.DTO.ProvinceDTO;
import com.example.app.Utility.Common.Request.Page;

import java.util.List;

public interface ProvinceRepositoryExt {
    List<ProvinceDTO> searchProvincePaging(Page page);
}
