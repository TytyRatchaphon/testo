package ku.cs.appeal_system.controllers.Admin;

import ku.cs.appeal_system.models.AccountList;
import ku.cs.appeal_system.services.AccountFileDataSource;
import ku.cs.appeal_system.services.DataSource;

public class UsernameListController {
    DataSource<AccountList> dataSource = new AccountFileDataSource();
    AccountList accounts = dataSource.readData();

}
