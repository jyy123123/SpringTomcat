package com.example.run;

import com.example.servlet.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.Servlet;

/**
 * @author yangyang.jiang
 * @Description:
 * @create 2020/7/16
 * @time 2:51 下午
 */
public class TomcatRunner {

    public static void run() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9999);
        tomcat.start();
        Context context = tomcat.addContext("/sp", "/Users/yigu/java");
        Servlet helloServlet = new HelloServlet();
        tomcat.addServlet("/sp", "hello", helloServlet);
        context.addServletMappingDecoded("/hello","hello");
        tomcat.getServer().await();
    }
}
