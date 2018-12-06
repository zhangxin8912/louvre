package com.zxin.louvre.learn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Proxy外包一层，持实际对象
 * 
 * 泛型
 *
 * @author zhangxin 2018年11月21日
 */
public class ProxyLearn implements InvocationHandler {

    private Object target;
    
    public static void main(String[] args) {
        ProxyHandle proxyHandle = new ProxyLearn().bind(new ProxyHandleImpl());
        proxyHandle.deal();
        
        //false
        System.out.println(proxyHandle instanceof ProxyHandleImpl);
        
    }

    /**
     * 绑定业务对象并返回一个代理类
     */
    public <T> T bind(Object target) {
        this.target = target;
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 包装调用方法：进行预处理、调用后处理
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        System.out.println("预处理操作——————");
        // 调用真正的业务方法
        result = method.invoke(target, args);

        System.out.println("调用后处理——————");
        return result;
    }

}

interface ProxyHandle {
    
    public void deal();
    
}

class ProxyHandleImpl implements ProxyHandle {
    
    @Override
    public void deal() {
        System.out.println("deal");
    }
    
}
