package ru.geekbrains.autumnmarket.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import ru.geekbrains.autumnmarket.products.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ProductRepositoryProxy implements ProductNewRepository {
    private List<Product> cache = null;
    private ProductNewRepository repository = new ProductRepository();

        @Override
        public List<Product> findAll() {
            if (cache == null) {
                cache = repository.findAll();
            }
            return cache;
        }

        @Override
        public List<Product> findAll(Sort sort) {
            if (cache == null) {
                cache = repository.findAll(sort);
            }
            return cache;
        }


        @Override
        public Page<Product> findAll(Pageable pageable) {

            return null;
        }

        @Override
        public List<Product> findAllById(Iterable<Long> longs) {

            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Product entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Product> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Product> S save(S entity) {
            return null;
        }

        @Override
        public <S extends Product> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public Optional<Product> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Product> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Product> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Product getOne(Long aLong) {
            return null;
        }

        @Override
        public Product getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Product> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Product> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Product> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Product> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Product, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    }
