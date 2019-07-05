package com.jesper.seckill.rabbitmq;

import com.jesper.seckill.bean.SeckillOrder;
import com.jesper.seckill.bean.User;
import com.jesper.seckill.redis.RedisService;
import com.jesper.seckill.service.GoodsService;
import com.jesper.seckill.service.OrderService;
import com.jesper.seckill.service.SeckillService;
import com.jesper.seckill.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DanLongChen on 2019/5/29.
 * 消息接收者
 */
@Service
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQReceiver.class);


    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    SeckillService seckillService;

    @RabbitListener(queues=MQConfig.QUEUE)
    public void receive(String message){
        log.info("receive message:"+message);
        SeckillMessage m = RedisService.stringToBean(message, SeckillMessage.class);
        User user = m.getUser();
        long goodsId = m.getGoodsId();
        /**
         * 接收到订单消息之后，从数据库查询秒杀商品的余量
         */
        GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goodsVo.getStockCount();
        /**
         * 余量不足，直接返回
         */
        if(stock <= 0){
            return;
        }

        /**
         * 余量充足的情况下，判断重复秒杀（判断方式就是使用用户id和商品id来查看秒杀订单）
         */
        SeckillOrder order = orderService.getOrderByUserIdGoodsId(user.getId(), goodsId);
        /**
         * 订单存在，那就是重复秒杀的情况
         */
        if(order != null) {
            return;
        }
        /**
         * 开始减库存，下订单，写入秒杀订单
         */
        seckillService.seckill(user, goodsVo);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE1)
    public void receiveTopic1(String message) {
        log.info(" topic  queue1 message:" + message);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE2)
    public void receiveTopic2(String message) {
        log.info(" topic  queue2 message:" + message);
    }
}
