package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

public class ProxyFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(ProxyFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();

        log.info(String.format("New Request: Server %s, Method: %s, Path %s",ctx.getRequest().getServerName()
                ,ctx.getRequest().getMethod(),
                ctx.getRequest().getRequestURI()));

        var headerNames= ctx.getResponse().getHeaderNames();
        headerNames.stream().forEach(header -> {
            log.info(String.format("Header: %s = %s", header, ctx.getResponse().getHeader(header)));
        });
        return null;
    }
}
