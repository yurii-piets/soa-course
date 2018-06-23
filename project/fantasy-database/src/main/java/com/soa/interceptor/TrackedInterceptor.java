package com.soa.interceptor;

import com.soa.domain.hero.Hero;
import com.soa.service.JMSService;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Tracked
@Interceptor
public class TrackedInterceptor {

    @Inject
    private JMSService jmsService;

    @AroundInvoke
    public Object invoke(InvocationContext ctx) throws Exception {
        try {
            return ctx.proceed();
        }
        finally {
            jmsService.send((Hero) ctx.getParameters()[0]);
        }
    }
}
