package io.github.kimmking.gateway.router.impl;

import io.github.kimmking.gateway.router.HttpEndpointRouter;

import java.util.List;

/**
 * 轮询路由
 *
 * Xingyufei
 *
 * 2020-11-01
 */
public class RoundRobinEndpointRouter implements HttpEndpointRouter {

    private int cur;

    @Override
    public String route(List<String> endpoints) {
        String res = endpoints.get(cur);
        if (cur == endpoints.size() - 1) {
            cur = 0;
        } else {
            cur++;
        }
        return res;
    }
}