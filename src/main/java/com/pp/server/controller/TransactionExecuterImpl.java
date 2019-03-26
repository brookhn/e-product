package com.pp.server.controller;

import org.apache.rocketmq.client.producer.LocalTransactionExecuter;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;

/**
 * 执行本地事务
 * @author taoyang
 *
 */
public class TransactionExecuterImpl implements LocalTransactionExecuter {

	@Override
	public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {
		// TODO Auto-generated method stub
		try {
			System.out.println(System.currentTimeMillis() + "本地事务执行成功，发送确认消息");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(System.currentTimeMillis() + "本地事务执行失败");
			return LocalTransactionState.ROLLBACK_MESSAGE;
		}
		return LocalTransactionState.COMMIT_MESSAGE;
	}

}
