package com.pp.server.controller;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;


public class RocketMQConsumerTest {
	
	
	public static void main(String[] args) throws MQClientException {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerTest");
		consumer.setNamesrvAddr("127.0.0.1:9876");
		consumer.subscribe("TopicTest", "TagB");
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
		consumer.registerMessageListener(new MessageListenerConcurrently() {
			
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext context) {
				Message message = list.get(0);
				System.out.println("=================consumer-------------------"+message.toString());
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		consumer.start();
		//consumer.setPersistConsumerOffsetInterval(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
	}
}
