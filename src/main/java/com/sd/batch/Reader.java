/**
 * 
 */
package com.sd.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author sreesdas
 *
 */
public class Reader implements ItemReader<String> {

	private String[] messages = { "javainuse.com", "Welcome to Spring Batch Example",
			"We use H2 Database for this example" };

	private int count = 0;

	/**
	 * @see org.springframework.batch.item.ItemReader#read()
	 */
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (count < messages.length) {
			return messages[count++];
		} else {
			count = 0;
		}
		return null;
	}

}
