package com.holdOrder.HoldOrder.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDatasource extends AbstractRoutingDataSource {

    // 현재 조회 키를 반환받기 위해 구현하는 추상 메소드
    // 여기에선 readOnly 속성을 구별하여 key 반환
    @Override
    protected Object determineCurrentLookupKey() {
        boolean readOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();

        if (readOnly) {
            logger.info("readOnly = true, request to slave");
            return "slave";
        }
        logger.info("readOnly = false, request to master");
        return "master";
    }

}
