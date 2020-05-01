package com.yi.minirpc.example;

import com.yi.minirpc.Peer;
import com.yi.minirpc.RpcClient;
import com.yi.minirpc.RpcClientConfig;

import java.util.Collections;
import java.util.List;

/**
 * @author YI
 * @date 2020/5/1
 */
public class Client {
    public static void main(String[] args) {
        List<Peer> servers = Collections.singletonList(new Peer("127.0.0.1", 8080));
        RpcClientConfig config = new RpcClientConfig();
        config.setServers(servers);

        RpcClient client = new RpcClient(config);
        CalcService service = client.getProxy(CalcService.class);

        String ip = service.getIp();
        String hi = service.hi("美女");
        System.out.println(hi + " 我顺着 " + ip + " 去找你！");
    }
}