package com.chenzhicheng.metaqtest.consumer;

import com.aliyun.openservices.ons.api.*;

import java.util.Date;
import java.util.Properties;

/**
 * Created by Administrator on 2016/5/22.
 */
public class BroadcastConsumerTest {

    public void consumerTest(){
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId, "CID-test-mrchen");//
        properties.put(PropertyKeyConst.AccessKey,"o6i0PsJE0w0vSUcF");// AccessKey 需要设置您自己的
        properties.put(PropertyKeyConst.SecretKey, "5dHAH76lxUGSyUPZLHAZBqbWkvmi9V ");// SecretKey 需要设置您自己的
        properties.put(PropertyKeyConst.MessageModel,PropertyValueConst.BROADCASTING);
        Consumer consumer = ONSFactory.createConsumer(properties);

        consumer.subscribe("mqtest-mrchen", "*", new MessageListener() {
            public Action consume(Message message, ConsumeContext context) {
                System.out.println(new Date() + "---Receive: " + message);
                return Action.CommitMessage;
            }
        });


        consumer.start();
        System.out.println("Consumer Started");
    }


    public static void main(String[] args){
        ClusterConsumerTest test = new ClusterConsumerTest();
        test.consumerTest();
    }

}
