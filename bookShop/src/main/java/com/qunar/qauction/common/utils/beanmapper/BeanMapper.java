package com.qunar.qauction.common.utils.beanmapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Description: Pylon bean mapper, which give out the ability to support java object mapping
 *
 * @author lingtong.fu
 * @version 2016-04-20 21:39
 */
public interface BeanMapper {
    <S, D> D map(S sourceObject, Class<D> destinationClass);

    <S, D> void map(S sourceObject, D destinationObject);

    <S, D> Set<D> mapAsSet(Iterable<S> source, Class<D> destinationClass);

    <S, D> Set<D> mapAsSet(S[] source, Class<D> destinationClass);

    <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass);

    <S, D> List<D> mapAsList(S[] source, Class<D> destinationClass);

    <S, D> D[] mapAsArray(D[] destination, Iterable<S> source, Class<D> destinationClass);

    <S, D> D[] mapAsArray(D[] destination, S[] source, Class<D> destinationClass);

    <S, D> void mapAsCollection(Iterable<S> source, Collection<D> destination, Class<D> destinationClass);

    <S, D> void mapAsCollection(S[] source, Collection<D> destination, Class<D> destinationClass);
}
