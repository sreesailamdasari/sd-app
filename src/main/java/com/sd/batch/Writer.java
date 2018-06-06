/**
 * 
 */
package com.sd.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/**
 * @author sreesdas
 *
 */
public class Writer implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> messages) throws Exception {
		for (String msg : messages) {
			System.out.println("Writing the data " + msg);
		}
	}

}
