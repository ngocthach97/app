package com.example.app.Repository.RepositoryExt;


import com.example.app.Model.Entity.Users;
import com.example.app.Utility.Common.Request.Search;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryExt {
    public List<Users> search(Search search);
}
