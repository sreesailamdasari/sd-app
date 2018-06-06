package com.sd.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * @author sreesdas
 *
 */
@Deprecated
public class OrderTransDao {

	private final static Logger LOGGER = Logger.getLogger(OrderTransDao.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<OrderTransaction> getOrderTransactionDeatils() {
		LOGGER.info("in getOrderTransactionDeatils() : ");
		String sqlQuery = "SELECT MSISDN, ORDERID, (to_char(to_timestamp(substr(TRANSDATE,1,14),'YYYYMMDDHH24:MI:SS'),'DD/MM/YYYY HH:MI:SS AM')) AS TRANSDATE "
				+ "FROM ORDER_TRANS WHERE TRANSDATE IS NOT NULL "
				+ "AND TO_CHAR(TO_TIMESTAMP(SUBSTR(TRANSDATE,1,14),'YYYYMMDDHH24:MI:SS'),'DD')=TO_CHAR(SYSDATE,'DD') "
				+ "AND TO_CHAR(TO_TIMESTAMP(SUBSTR(TRANSDATE,1,14),'YYYYMMDDHH24:MI:SS'),'MON')=(SELECT TO_CHAR(SYSDATE,'MON') FROM DUAL) "
				+ "AND REASONCODE IN('10001','10002','10004') ORDER BY TRANSDATE DESC";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		OrderTransaction orderTrans = null;
		List<OrderTransaction> orderTransList = new ArrayList<OrderTransaction>();
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sqlQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				orderTrans = new OrderTransaction();
				orderTrans.setMsisdn(resultSet.getString("MSISDN"));
				orderTrans.setOrderId(resultSet.getString("ORDERID"));
				orderTrans.setTransDate(resultSet.getString("TRANSDATE"));
				orderTransList.add(orderTrans);
			}
		} catch (SQLException sqlexp) {
			LOGGER.info("Exception in OrderTransDao : " + sqlexp);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException sqlexp) {
				LOGGER.info("Exception in OrderTransDaoImpl : " + sqlexp);
			}
		}
		return orderTransList;
	}

}