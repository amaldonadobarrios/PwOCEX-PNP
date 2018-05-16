package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Farid
 */
public class ConectaDB {

    private final String database;

    public Connection getConnection() throws SQLException{
        Connection cn = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(
                  //  "jdbc:jtds:sqlserver://172.31.0.10;instance=SQLCLUSTER10;" + database,  
                  //  "usuario_lvidal", "vidal");
            		// "jdbc:jtds:sqlserver://172.31.0.10;instance=;" + database,  
                      // "usuario_lvidal", "vidal");
            	/*	"jdbc:jtds:sqlserver://172.31.1.53;instance=SQLCLUSTER10;" + database, 
            		"usuario_lvidal", "vidal2016");*/

            		

            		
            		"jdbc:jtds:sqlserver://PUMA-DBD;instance=;" + database, 
            		"usuario_lvidal", "vidal2020");	
            
//            "jdbc:jtds:sqlserver://172.31.0.10;instance=SQLCLUSTER10;" + database,// anterior
//            "diper_readonly", "demabada");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectaDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ConectaDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConectaDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cn;
    }

    public ConectaDB() {
        this.database = "DIPER";
    }

    public ConectaDB(String database) {
        this.database = database;
    }

}
