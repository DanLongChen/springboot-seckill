package com.jesper.seckill.redis;

/**
 * Created by DanLongChen on 2019/5/29.
 */
public class SeckillKey extends BasePrefix {
    private SeckillKey(String prefix) {
        super(prefix);
    }

    public static SeckillKey isGoodsOver = new SeckillKey("go");
}
