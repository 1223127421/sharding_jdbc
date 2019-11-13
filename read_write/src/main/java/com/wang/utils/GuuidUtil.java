package com.wang.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * 每个服务编写一个生成ID工具类
 */
public class GuuidUtil {

    // 机器ID
    @Value("${IdWorker.machineId}")
    private static long machineId;
    //数据标识ID
    @Value("${IdWorker.datacenterId}")
    private static long datacenterId;

    /**
     * 生成id
     *
     * @return
     */
    public static long getUUID() {
        return SnowFlakeSingleton.Singleton.getInstance().createId();
    }

    /**
     * 单例模式创建学法算法对象
     */
    private enum SnowFlakeSingleton {
        Singleton;
        private SnowFlake snowFlake;

        SnowFlakeSingleton() {
            snowFlake = new SnowFlake(datacenterId, machineId);
        }

        public SnowFlake getInstance() {
            return snowFlake;
        }
    }

}
