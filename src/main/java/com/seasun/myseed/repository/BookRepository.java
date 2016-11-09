package com.seasun.myseed.repository;

import com.seasun.myseed.domain.Book;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;



@CacheConfig(cacheNames = "books")
public interface BookRepository extends JpaRepository<Book,Long>{


   @Cacheable
   Book findByName(String name);

}
