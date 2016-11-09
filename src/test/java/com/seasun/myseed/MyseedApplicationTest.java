package com.seasun.myseed;

import com.seasun.myseed.domain.Book;
import com.seasun.myseed.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MySeedApplication.class)
@ActiveProfiles("local")
public class MyseedApplicationTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void before() {
        Book book = new Book();
        book.setId(1001);
        book.setName("AAA");
        book.setAuthor("xionghaitao");
        bookRepository.save(book);
    }

    @Test
    public void test() throws Exception {
        Book u1 = bookRepository.findByName("AAA");
        System.out.println("第一次查询：" + u1.getName());

        System.out.print("cacheManager is:"+ cacheManager.toString());
        Book u2 = bookRepository.findByName("AAA");
        System.out.println("第二次查询：" + u2.getName());
    }

}
