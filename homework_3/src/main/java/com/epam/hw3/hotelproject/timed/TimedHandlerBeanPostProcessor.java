package com.epam.hw3.hotelproject.timed;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class TimedHandlerBeanPostProcessor implements BeanPostProcessor {
    private static final Logger LOGGER = Logger.getLogger(TimedHandlerBeanPostProcessor.class);
    public static final String BEAN_NAME = "bean name: ";

    private final Map<String, Class<?>> map = new HashMap<>();
    private final TimedController controller = new TimedController();

    public TimedHandlerBeanPostProcessor() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(controller, new ObjectName("timed", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Timed.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        Class<?> beanClass = map.get(beanName);
        if (beanClass != null) {

            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            if (controller.isEnabled()) {
                                long before = System.nanoTime();
                                LOGGER.debug(BEAN_NAME + beanName + " start executing: " + before);
                                Object retVal = method.invoke(bean, args);
                                long after = System.nanoTime();
                                LOGGER.debug(BEAN_NAME + beanName + " end executing: " + after);
                                LOGGER.trace(BEAN_NAME + beanName + " total executing time: " + (after - before));
                                LOGGER.debug("end profiling");
                                return retVal;
                            } else {
                                return method.invoke(bean, args);
                            }
                        }
                    }
            );
        }
        return bean;
    }
}
