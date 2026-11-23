package dk.sea.mytunes.DAL.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class DBConnector {
    private static final String PROP_FILE = "config/database.settings";
    private SQLServerDataSource dataSource;
}
