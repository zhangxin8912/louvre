package com.zxin.louvre.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AsyncApplicationWithAnnotation.class)
public class AsyncApplicationWithAnnotationTests {

    @Autowired
    private AsyncDemo asyncDemo;

    @Test
    public void contextLoads() throws InterruptedException, ExecutionException {
        asyncDemo.asyncInvokeSimplest();
        System.out.println("main 1");
        asyncDemo.asyncInvokeWithParameter("test");
        System.out.println("main 2");
        Future<String> future = asyncDemo.asyncInvokeReturnFuture(100);
        System.out.println("main 3");
        System.out.println(future.get());
    }

}
