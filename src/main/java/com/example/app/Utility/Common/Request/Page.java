package com.example.app.Utility.Common.Request;

import com.example.app.Utility.Common.Validator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private int size;

    private int page;

    private String sort;

    public Pageable getPageable() {
        Sort sortable = null;
        Pageable pageable = null;
        if (Validator.isNull(this.getSort())) {
            pageable = PageRequest.of(this.getPage(), this.getSize());
        } else {
            if (Validator.equals(this.getSort(), "ASC")) {
                sortable = Sort.by("id").ascending();
            }
            if (Validator.equals(this.getSort(), "DESC")) {
                sortable = Sort.by("id").descending();
            }
            pageable = PageRequest.of(this.getPage(), this.getSize(), sortable);
        }
        return pageable;
    }
}
