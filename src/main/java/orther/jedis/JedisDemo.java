package orther.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author qin
 * @description jedis
 * @date 2021-05-03
 */
public class JedisDemo {

    private int maxActive = 600;
    private int maxIdle = 300;
    private int minIdle = 100;
    private String host = "localhost";
    private int port = 6379;
    private int timeout = 2000;
    private String password = "";

    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMinIdle(minIdle);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        return jedisPool;
    }

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        jedis.set("key:a","123");
        jedis.set("key:b","456");
        String valB = jedis.get("key:b");
        assert valB.equals("456");
        System.out.println(valB);
    }

}
