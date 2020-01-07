package com.yl.test.jmx;

import javax.management.*;
import javax.management.remote.*;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.util.Arrays;
import java.util.List;


/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/10/31  10:22
 */
public class HelloAgent {

    public static void main(String[] args) throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        ObjectName helloName = new ObjectName("chengang:name=HelloWorld");
        ObjectName helloName2 = new ObjectName("chengang:name=HelloWorld2");
        server.registerMBean(new Hello(), helloName);
        server.registerMBean(new Hello(), helloName2);
        LocateRegistry.createRegistry(8081);

        JMXServiceURL url = new JMXServiceURL
                ("service:jmx:rmi:///jndi/rmi://localhost:8081/jmxrmi");
        JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);

        jcs.start();
        System.out.println("start.....");
//
    }

    public static void excuteJmxRemote() throws Exception {
        final  JMXServiceURL url = new JMXServiceURL
                ("service:jmx:rmi:///jndi/rmi://localhost:8081/jmxrmi");
        JMXConnector jmxConnector = JMXConnectorFactory.newJMXConnector(url,null);
        final MBeanServerConnection mBeanServerConnection = jmxConnector.getMBeanServerConnection();
        ObjectName helloName = new ObjectName("chengang:name=HelloWorld");
        HelloMBean mbean = JMX.newMBeanProxy(mBeanServerConnection,helloName,HelloMBean.class);
        mbean.printHello("hahhahhahahhah");
    }
}
