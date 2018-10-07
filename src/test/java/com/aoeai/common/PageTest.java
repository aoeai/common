package com.aoeai.common;

import com.aoeai.common.exception.PageException;
import com.aoeai.common.utils.Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageTest {

    @Test(expectedExceptions = PageException.class)
    public void test1(){
        Page page = new Page(10, 1);
        Assert.assertEquals(page.getTotalPages(), 1);
        Assert.assertEquals(page.getOffset(), 0);

        page = new Page(10, 11);
        Assert.assertEquals(page.getTotalPages(), 2);
        Assert.assertEquals(page.getOffset(), 0);

        page.setPageNum(3); // 抛出异常

        page.setPageNum(1);
        Assert.assertEquals(page.getOffset(), 0);

        page.setPageNum(2);
        Assert.assertEquals(page.getOffset(), 10);
    }

    @Test
    public void test3(){
        Page page = new Page(10, 11);

        page.setPageNum(1);
        Assert.assertEquals(page.getOffset(), 0);
        Assert.assertEquals(page.getTotalPages(), 2);

        page.setPageNum(2);
        Assert.assertEquals(page.getOffset(), 10);
    }

    @Test(expectedExceptions = PageException.class)
    public void test4(){
        new Page(0, 1);
    }

    @Test(expectedExceptions = PageException.class)
    public void test5(){
        new Page(-1, 1);
    }

    @Test(expectedExceptions = PageException.class)
    public void test6(){
        new Page(10, -1);
    }

    @Test(expectedExceptions = PageException.class)
    public void test7(){
        Page page = new Page(10, 0);
        Assert.assertEquals(page.getTotalPages(), 0);
        Assert.assertEquals(page.getOffset(), 0);

        page.setPageNum(1);
        page.setPageNum(0);
    }

    @Test
    public void test8(){
        Page page = new Page(10, 101);

        Assert.assertEquals(page.getOffset(), 0);
        Assert.assertEquals(page.getTotalPages(), 11);

        page.setPageNum(1);
        Assert.assertEquals(page.getOffset(), 0);
        Assert.assertEquals(page.getTotalPages(), 11);

        page.setPageNum(10);
        Assert.assertEquals(page.getOffset(), 90);

        page.setPageNum(11);
        Assert.assertEquals(page.getOffset(), 100);
    }

    @Test
    public void test9(){
        Page page = new Page(10, 99);

        Assert.assertEquals(page.getOffset(), 0);
        Assert.assertEquals(page.getTotalPages(), 10);

        page.setPageNum(1);
        Assert.assertEquals(page.getOffset(), 0);
        Assert.assertEquals(page.getTotalPages(), 10);

        page.setPageNum(10);
        Assert.assertEquals(page.getOffset(), 90);

        page.setPageNum(3);
        Assert.assertEquals(page.getOffset(), 20);
        Assert.assertEquals(page.getTotalCount(), 99);
    }
}
