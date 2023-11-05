package com.jeizard.scheduleapp.data.mapper;

import java.util.Collection;
import java.util.List;

public interface Mapper<D, E> {
    E mapFromDBEntity(D d);

    D mapToDBEntity(E e);

    List<E> mapFromDBEntity(Collection<D> d);

    List<D> mapToDBEntity(Collection<E> e);
}
