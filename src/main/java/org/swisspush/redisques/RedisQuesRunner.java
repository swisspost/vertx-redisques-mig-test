package org.swisspush.redisques;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.slf4j.LoggerFactory;
import org.swisspush.redisques.util.RedisquesConfiguration;

/**
 * Deploys vertx-redisques to vert.x.
 * Used in the standalone scenario.
 *
 * @author https://github.com/mcweba [Marc-Andre Weber]
 */
public class RedisQuesRunner {

    public static void main(String[] args) {

        JsonObject configuration = RedisquesConfiguration.with()
                .httpRequestHandlerEnabled(true)
                .build().asJsonObject();

        Vertx.vertx().deployVerticle("org.swisspush.redisques.RedisQues", new DeploymentOptions().setConfig(configuration),
                event -> LoggerFactory.getLogger(RedisQues.class).info("vertx-redisques started"));
    }
}
