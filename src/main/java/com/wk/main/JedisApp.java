package com.wk.main;
/**
 * Created by lenovo on 2018/3/30.
 */

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lenovo
 * @create 2018-03-30 15:04
 **/
public class JedisApp {

    public static void main(String[] args) {

            // 创建jedisCluster
            Set<HostAndPort> nodes = new HashSet<>();
            nodes.add(new HostAndPort("39.107.113.43",7001));
            nodes.add(new HostAndPort("39.107.113.43",7002));
            nodes.add(new HostAndPort("39.107.113.43",7003));
            nodes.add(new HostAndPort("39.107.113.43",7004));
            nodes.add(new HostAndPort("39.107.113.43",7005));
            nodes.add(new HostAndPort("39.107.113.43",7006));
            JedisCluster cluster = new JedisCluster(nodes);
            cluster.set("s4","444");
            String result = cluster.get("s4");
            System.out.println(result);
        try {
            cluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
