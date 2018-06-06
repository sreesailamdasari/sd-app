/**
 * 
 */
package com.sd.batch;

import org.springframework.batch.item.ItemProcessor;

/**
 * @author sreesdas
 *
 */
public class Processor implements ItemProcessor<String, String> {

	@Override
	public String process(String data) throws Exception {
		return data.toUpperCase();
	}

}
