package com.example;

import com.example.run.TomcatRunner;
import org.apache.catalina.LifecycleException;

/**
 * @author yangyang.jiang
 * @Description:
 * @create 2020/7/16
 * @time 2:50 下午
 */
public class TomcatApplication {

    /**
     * main方法入口，仿造springboot的入口
     * @param args
     */
    public static void main(String[] args) throws LifecycleException {
        TomcatRunner.run();
    }
}
