package com.pp.server.common.sharding;

import com.google.common.collect.Range;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;


/**
 * 根据单个字段hash来分表的实现
 *
 */
public class RangeKeyHashShardingAlgorithm implements RangeShardingAlgorithm<Long>{

	/**
	 * 支持between
	 * */
	@Override
	public Collection<String> doSharding(Collection<String> allActualTableNames, RangeShardingValue<Long> paramShardingValue) {
		Collection<String> actualTableNames = new ArrayList<>();
        Range<Long> valueRange = paramShardingValue.getValueRange();
        for (Long i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            for (String each : allActualTableNames) {
				String key = Math.abs(i.hashCode()) % allActualTableNames.size()+"";
                if (each.endsWith(key)) {
                	actualTableNames.add(each);
                }
            }
        }
        return actualTableNames;
    }
	
	public static void main(String[] args) throws ParseException {
		String val = "2018-07-08 00";
		String key = new SimpleDateFormat("yyyyMM").format(new SimpleDateFormat("yyyy-MM-dd HH").parse(val));
		System.out.println(key);
	}

	
}
