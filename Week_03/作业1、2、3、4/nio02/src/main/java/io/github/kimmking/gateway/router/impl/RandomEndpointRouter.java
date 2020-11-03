package io.github.kimmking.gateway.router.impl;

import io.github.kimmking.gateway.router.HttpEndpointRouter;

import java.util.List;
import java.util.Random;

/**
 * 随机路由
 *
 * Xingyufei
 *
 * 2020-11-01
 */
public class RandomEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> endpoints) {
        Random random = new Random();
        return endpoints.get(random.nextInt(endpoints.size()));
    }
}
