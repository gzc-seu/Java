package com.imooc.spring.ioc.class06;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Bean {
    private AnotherBean anotherBean;
    private String string;

    private AnotherBean anotherBean1;
    private String string1;

    private List<String> stringList;
    private List<AnotherBean> anotherBeanList;
    private Map<String,String> stringMap;
    private Map<AnotherBean,AnotherBean> anotherBeanmap;
    private Set<String> stringset;
    private Set<AnotherBean> anotherBeanset;
    private Properties properties;

    private AnotherBean anotherBean2;

    public AnotherBean getAnotherBean2() {
        return anotherBean2;
    }

    public void setAnotherBean2(AnotherBean anotherBean2) {
        this.anotherBean2 = anotherBean2;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<AnotherBean> getAnotherBeanList() {
        return anotherBeanList;
    }

    public void setAnotherBeanList(List<AnotherBean> anotherBeanList) {
        this.anotherBeanList = anotherBeanList;
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public Map<AnotherBean, AnotherBean> getAnotherBeanmap() {
        return anotherBeanmap;
    }

    public void setAnotherBeanmap(Map<AnotherBean, AnotherBean> anotherBeanmap) {
        this.anotherBeanmap = anotherBeanmap;
    }

    public Set<String> getStringset() {
        return stringset;
    }

    public void setStringset(Set<String> stringset) {
        this.stringset = stringset;
    }

    public Set<AnotherBean> getAnotherBeanset() {
        return anotherBeanset;
    }

    public void setAnotherBeanset(Set<AnotherBean> anotherBeanset) {
        this.anotherBeanset = anotherBeanset;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public AnotherBean getAnotherBean1() {
        return anotherBean1;
    }

    public void setAnotherBean1(AnotherBean anotherBean1) {
        this.anotherBean1 = anotherBean1;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public AnotherBean getAnotherBean() {
        return anotherBean;
    }

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "anotherBean=" + anotherBean +
                ", string='" + string + '\'' +
                ", anotherBean1=" + anotherBean1 +
                ", string1='" + string1 + '\'' +
                ", stringList=" + stringList +
                ", anotherBeanList=" + anotherBeanList +
                ", stringMap=" + stringMap +
                ", anotherBeanmap=" + anotherBeanmap +
                ", stringset=" + stringset +
                ", anotherBeanset=" + anotherBeanset +
                ", properties=" + properties +
                ", anotherBean2=" + anotherBean2 +
                '}';
    }

    public Bean(AnotherBean anotherBean, String string) {
        this.anotherBean = anotherBean;
        this.string = string;
    }
}
