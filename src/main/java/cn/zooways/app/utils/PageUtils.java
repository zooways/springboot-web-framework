package cn.zooways.app.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.function.Function;

/**
 * @Description:
 * @Author: Zoowayss Shi
 * @Date: 2023/4/13 14:22
 * @Version: 1.0
 */

public class PageUtils {

    /**
     * @param pageable interface org.springframework.data.domain.Pageable
     * @return Class com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> implements IPage<T>
     */
    public static Page of(Pageable pageable) {
        return Page.of(pageable.getPageNumber() + 1, pageable.getPageSize());
    }

    /**
     * @param page interface com.baomidou.mybatisplus.core.metadata.IPage<T>
     * @return interface org.springframework.data.domain.Page
     */
    public static org.springframework.data.domain.Page from(IPage page) {
        return new PageImpl(page.getRecords(), of(page), page.getTotal());
    }

    /**
     *
     * @param page interface com.baomidou.mybatisplus.core.metadata.IPage<T>
     * @return  interface org.springframework.data.domain.Pageable
     */
    public static Pageable of(IPage page) {
        return PageRequest.of((int) page.getCurrent(), (int) page.getSize());
    }

    /**
     *
     * @param function
     * @param pageable interface org.springframework.data.domain.Pageable
     * @return interface org.springframework.data.domain.Page
     */
    public static org.springframework.data.domain.Page request(Function<Page, IPage> function, Pageable pageable) {
        return from(function.apply(of(pageable)));
    }
}
