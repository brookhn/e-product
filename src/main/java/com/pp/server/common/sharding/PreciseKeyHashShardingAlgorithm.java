package com.pp.server.common.sharding;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;


/**
 * 根据单个字段hash来分表的实现
 *
 */
public class PreciseKeyHashShardingAlgorithm implements PreciseShardingAlgorithm<String> {

	/**
	 * 支持==和in
	 * */
	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
		// 逻辑表名
		String logicTableName = shardingValue.getLogicTableName();
		// 根据比较的值，算出物理分表
		String val = String.valueOf(shardingValue.getValue());
		String actualTableName = "";
		if (val != null && !"".equals(val)) {
			actualTableName = logicTableName + "_" + Math.abs(val.hashCode()) % availableTargetNames.size();
		}
		if (availableTargetNames.contains(actualTableName))
			return actualTableName;

		// 如果没有匹配到相应的物理表名，那一定是有问题的
		throw new UnsupportedOperationException();
	}
	
	public static void main(String[] args) {
		int i = Math.abs("18648360177".hashCode()) % 9;
		System.out.println(i);
	}
}
