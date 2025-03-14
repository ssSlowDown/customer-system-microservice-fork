package org.geekbang.projects.cs.middleground.task.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.geekbang.projects.cs.middleground.task.feign.CustomerStaffSyncClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 同步客服人员信息调度任务处理器
 */
@Component
public class CustomerStaffSyncJobHandler {

    @Autowired
    private CustomerStaffSyncClient customerStaffSyncClient;

    private static Logger logger = LoggerFactory.getLogger(CustomerStaffSyncJobHandler.class);

    @XxlJob("customerStaffSyncJobHandler")
    public ReturnT<String> syncCustomerStaff() throws Exception {
        logger.info(new Date() + "：同步客服信息~");

        String param = XxlJobHelper.getJobParam();
        Long systemId = Long.parseLong(param);

        //触发远程调用，获取客服信息并保存
        customerStaffSyncClient.syncOutsourcingCustomerStaffsBySystemId(systemId);

        return ReturnT.SUCCESS;
    }
}
