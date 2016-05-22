package com.chenzhicheng.metaqtest.product;

import com.aliyun.openservices.ons.api.*;

import java.util.Date;
import java.util.Properties;

/**
 * Created by Administrator on 2016/5/22.
 */
public class ProductTest {


    public void productMsg(){
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ProducerId, "PID-test-mrchen");// ProducerId��Ҫ�������Լ���
        properties.put(PropertyKeyConst.AccessKey,"o6i0PsJE0w0vSUcF");// AccessKey ��Ҫ�������Լ���
        properties.put(PropertyKeyConst.SecretKey, "5dHAH76lxUGSyUPZLHAZBqbWkvmi9V ");// SecretKey ��Ҫ�������Լ���
        Producer producer = ONSFactory.createProducer(properties);
        // �ڷ�����Ϣǰ���������start����������Producer��ֻ�����һ�μ��ɡ�
        producer.start();

        Message msg = new Message(
                // Message Topic
                "mqtest-mrchen",
                // Message Tag,
                // �����ΪGmail�еı�ǩ������Ϣ�����ٹ��࣬����Consumerָ������������ONS����������
                "TagA",
                // Message Body
                // �κζ�������ʽ�����ݣ� ONS�����κθ�Ԥ��
                // ��ҪProducer��ConsumerЭ�̺�һ�µ����л��ͷ����л���ʽ
                "Hello ONS".getBytes());
        // ���ô�����Ϣ��ҵ��ؼ����ԣ��뾡����ȫ��Ψһ��
        // �Է��������޷������յ���Ϣ����£���ͨ��ONS Console��ѯ��Ϣ��������
        // ע�⣺������Ҳ����Ӱ����Ϣ�����շ�
        msg.setKey("test6");
        // ������Ϣ��ֻҪ�����쳣���ǳɹ�
        SendResult sendResult = producer.send(msg);
        System.out.println(new Date().toString() + "---" + sendResult);


        // ��Ӧ���˳�ǰ������Producer����
        // ע�⣺���������Ҳû������
        producer.shutdown();
    }

    public static void main(String[] args) {
        ProductTest test = new ProductTest();
        test.productMsg();
    }

}
