package com.imooc.spring.ioc.class1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实例化Bean
 * 保存Bean
 * 提供Bean
 */
public class IocContainer {
    private Map<String,Object>beans=new ConcurrentHashMap<>();

    /**
     * 根据beanid，获得一个bean
     * @param beanId string的id
     * @return 返回bean
     */
    public Object getbean(String beanId){
        return beans.get(beanId);
    }

    /**
     * 委托IOC容器创建一个bean
     * @param clazz 要创建的bean的class
     * @param beanId string的id
     * @param paramBeanIds 要创建的bean的class发热构造方法所需要的参数的beanid们
     */
    public void setBeans(Class<?>clazz,String beanId,String... paramBeanIds) {
        //1.组装构造方法所需要的参数值
        Object[] paraments=new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paraments[i]=beans.get(paramBeanIds[i]);
        }
        //2.利用构造方法实例化bean
        Object bean=null;
        for(Constructor<?> constructor:clazz.getConstructors()){
            try {
                bean = constructor.newInstance(paraments);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
        if(bean==null){
            throw new RuntimeException("找不到构造方法");
        }
        //3.将实例化的bean放入beans
        beans.put(beanId,bean);
    }
}
