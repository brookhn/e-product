package com.pp.server.controller;

import java.io.UnsupportedEncodingException;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionCheckListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class RocketMQProducerTest {
	
	public void transactionMq() {
		TransactionCheckListener checkListener = new TransactionCheckListener() {
			
			@Override
			public LocalTransactionState checkLocalTransactionState(MessageExt msg) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	
	public static void main(String args[]) throws MQClientException, UnsupportedEncodingException, RemotingException, MQBrokerException, InterruptedException {
		DefaultMQProducer producer = new DefaultMQProducer("ProducerTest");
		producer.setVipChannelEnabled(false);
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();
		try {
			int index = 0;
			while(true) {
			    Message msg = new Message("TopicTest",// topic
		             "TagB",// tag
		             ("Hello RocketMQ test" + index++).getBytes(RemotingHelper.DEFAULT_CHARSET)// body
		        );
				 
			    SendResult sendResult = producer.send(msg);
		        // 打印返回结果
		        System.out.println(sendResult); 
		        Thread.sleep(1000);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			producer.shutdown();
		}
	}
}
