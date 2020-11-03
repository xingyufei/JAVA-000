package io.github.kimmking.gateway.router;

import io.github.kimmking.gateway.router.impl.HashEndpointRouter;
import io.github.kimmking.gateway.router.impl.RandomEndpointRouter;
import io.github.kimmking.gateway.router.impl.RoundRobinEndpointRouter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 路由工厂
 *
 * Xingyufei
 *
 * 2020-11-01
 */
public class HttpEndPointRouterFactory {

    private static final Map<String, HttpEndpointRouter> routerMap = new ConcurrentHashMap<>(3);

    static {
        routerMap.put("hash", new HashEndpointRouter());
        routerMap.put("random", new RandomEndpointRouter());
        routerMap.put("roundRobin", new RoundRobinEndpointRouter());
    }

    public static HttpEndpointRouter select(String rule){
        return routerMap.get(rule);
    }

}
