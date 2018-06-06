/**
 * 
 */
package com.sd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * @author sreesdas
 *
 */
public class SFTPLoginWithPPKFile extends HttpServlet implements Runnable {

	private static final long serialVersionUID = 1493835679721223795L;
	private final static Logger LOGGER = Logger.getLogger(SFTPLoginWithPPKFile.class);

	private static final String HOST = "host name";
	private static final int PORT = 22;
	private static final String USER = "username of server";
	// file location from class path
	private final String PRIVATE_KEY_LOCATION = "resources/ppkfile/sftp_private.ppk";

	public void init() {
		LOGGER.info("init() in Appconfig ");
		long initalDelay = initalDelay();
		LOGGER.info("Inital Delay in seconds : " + initalDelay);
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(new SFTPLoginWithPPKFile(), initalDelay, 24 * 60 * 60, TimeUnit.SECONDS);
	}

	public void run() {
		LOGGER.info("run() in Appconfig ");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderTransDao orderTransDao = appContext.getBean("orderTransDao", OrderTransDao.class);
		List<OrderTransaction> orderTransactions = orderTransDao.getOrderTransactionDeatils();
		LOGGER.info("Total Records : " + orderTransactions.size());
		// LOGGER.info(orderTransactions.toString());
		FileWriter fileWriter = null;
		File file = null;
		FileOutputStream fileOutputStream = null;
		String fileName = "Celcom_Lifecycles";
		DateFormat dateFormat = new SimpleDateFormat("ddMMYYYYHHmmss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		try {
//			file = new File("D://Celcom//Lifecycle//CSV//"+fileName + "_" + currentDate + ".csv");
			file = new File("../" + fileName + "_" + currentDate + ".csv");
			fileOutputStream = new FileOutputStream(file);
			LOGGER.info("File name : " + file.getAbsoluteFile().getName());
			fileWriter = new FileWriter(file);
			FileWriterUtil fileWriterUtil = new FileWriterUtil();
			fileWriterUtil.appendColumns(fileWriter);
			for (OrderTransaction orderTrans : orderTransactions) {
				String customerMobileNumber = orderTrans.getMsisdn();
				String transDate = orderTrans.getTransDate();
				fileWriterUtil.appendValues(customerMobileNumber, transDate, fileWriter);
			}
			fileWriter.flush();
			fileOutputStream.close();
			fileWriter.close();
		} catch (IOException e) {
			LOGGER.error(e.getClass().getName() + " : " + e.getMessage());
		}
		transferFileToSFTPFolder(file);
		LOGGER.info("Again File will be generated in seconds : " + initalDelay());
	}

	private void transferFileToSFTPFolder(File file) {
		LOGGER.info("Transfering file to SFTP ");
		JSch jSch = new JSch();
		// read PPK file
		final byte[] privateKey = getPrivateKeyAsByteStream();
		ChannelSftp sftp = null;
		Session session = null;
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			LOGGER.info(keyFactory.getProvider().getName());
			jSch.addIdentity(USER, privateKey, null, new byte[0]);
			session = jSch.getSession(USER, HOST, PORT);
			// session.setPassword("set password");
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect(5000);
			Channel channel = session.openChannel("sftp");
			sftp = (ChannelSftp) channel;
			sftp.connect();
			sftp.cd("/home/V07089X/Share/NPS/");// server destination path
			sftp.put(new FileInputStream(file), file.getName());
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("NoSuchAlgorithmException : " + e);
		} catch (FileNotFoundException e) {
			LOGGER.error("FileNotFoundException : " + e);
		} catch (SftpException e) {
			LOGGER.error("SftpException : " + e);
		} catch (JSchException e) {
			LOGGER.error("JSchException : " + e);
		} finally {
			sftp.disconnect();
			session.disconnect();
		}
	}

	private byte[] getPrivateKeyAsByteStream() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		final File privateKeyLocation = new File(classLoader.getResource(PRIVATE_KEY_LOCATION).getFile());
		// final File privateKeyLocation = new File(PRIVATE_KEY_LOCATION);
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(privateKeyLocation);
			// inputStream=AppConfig.getClass().getResourceAsStream(PRIVATE_KEY_LOCATION);
		} catch (FileNotFoundException e) {
			LOGGER.error("FileNotFoundException : " + e);
		}
		long length = privateKeyLocation.length();
		if (length > Integer.MAX_VALUE) {
			try {
				throw new IOException("File to process is too big to process in this example.");
			} catch (IOException e) {
				LOGGER.error("IOException : " + e);
			}
		}
		final byte[] bytes = new byte[(int) length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		try {
			while ((offset < bytes.length)
					&& ((numRead = inputStream.read(bytes, offset, bytes.length - offset)) >= 0)) {
				offset += numRead;
			}
		} catch (IOException e) {
			LOGGER.error("IOException : " + e);
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			try {
				throw new IOException("Could not completely read file " + privateKeyLocation.getName());
			} catch (IOException e) {
				LOGGER.error("IOException : " + e);
			}
		}
		try {
			inputStream.close();
		} catch (IOException e) {
			LOGGER.error("IOException : " + e);
		}
		return bytes;
	}

	/**
	 * @return
	 */
	private long initalDelay() {
		LocalDateTime localNow = LocalDateTime.now();
		// Malesiya time zone
		// ZoneId malesiyaZone = ZoneId.of("Asia/Kuala_Lumpur");
		// India time zone
//		ZoneId indiaZone = ZoneId.of("Asia/Kolkata");
		ZoneId zoneId = ZoneId.systemDefault();

		ZonedDateTime zonedNow = ZonedDateTime.of(localNow, zoneId);
		ZonedDateTime zonedNext;
		// Here you need to set the time when it has to start - suppose if you want run
		// the scheduler midnight 1.30 am you need to mention time as - 13-30-0
		zonedNext = zonedNow.withHour(21).withMinute(30).withSecond(0);
		if (zonedNow.compareTo(zonedNext) > 0)
			zonedNext = zonedNext.plusDays(1);
		Duration duration = Duration.between(zonedNow, zonedNext);
		return duration.getSeconds();
	}
}