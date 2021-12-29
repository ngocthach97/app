package com.example.app.Model.Utility;

import java.util.List;
public interface Mapper<E,D> {

    D toEntityDTO(E e) ;

    E toDTOEntity (D d) ;

    List<D> toListEntityListDTO(List<E> e) ;

    List<E> toListDTOListEntity(List<D> d) ;
}
