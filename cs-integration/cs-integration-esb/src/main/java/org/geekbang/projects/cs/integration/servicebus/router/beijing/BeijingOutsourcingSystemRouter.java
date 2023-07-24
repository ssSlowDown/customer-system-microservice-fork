package org.geekbang.projects.cs.integration.servicebus.router.beijing;

import org.geekbang.projects.cs.integration.servicebus.router.OutsourcingSystemRouter;
import org.geekbang.projects.cs.integration.servicebus.router.beijing.dto.BeijingCustomerStaff;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeijingOutsourcingSystemRouter implements OutsourcingSystemRouter<BeijingCustomerStaff> {

    @Override
    public List<BeijingCustomerStaff> fetchOutsourcingCustomerStaffs(String systemUrl) {

        return null;
    }
}
