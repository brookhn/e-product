package com.pp.server.controller;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionCheckListener;
import org.apache.rocketmq.common.message.MessageExt;

public class TransactionCheckListenerImpl implements TransactionCheckListener{

	@Override
	public LocalTransactionState checkLocalTransactionState(MessageExt msg) {
		// TODO Auto-generated method stub
		System.out.println("server checking TrMsg"+ msg.toString());
		return LocalTransactionState.COMMIT_MESSAGE;
	}

}
