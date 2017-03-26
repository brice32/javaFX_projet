package contacts;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import contacts.commun.service.IContextService;
import contacts.emb.dao.IContextDao;
import contacts.emb.util.jdbc.DataSourceSingleConnection;
import contacts.javafx.model.IContextModel;
import contacts.javafx.view.IManagerGui;


public class MainContacts {


	// main()

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// Logger
		Logger logger = Logger.getLogger( MainContacts.class.getName() );

		// Composants de l'application
		DataSourceSingleConnection	dataSource;
		IContextDao					contextDao;
		IContextService				contextService;
		IContextModel 				contextModel;
		IManagerGui					managerGui;

		try {

			// Configuration de la trace
			configurerLogging();

			// JDBC
			dataSource =
//					null;
					new DataSourceSingleConnection( MainContacts.class.getResourceAsStream( "/META-INF/jdbc.properties" ) );

			contextDao =
//					null;
//					new contacts.emb.dao.mock.ContextDao();
					new contacts.emb.dao.jdbc.ContextDao( dataSource );

			contextService =
//					null;
//					new contacts.emb.service.mock.ContextService();
					new contacts.emb.service.standard.ContextService( contextDao );

			contextModel =
//					new contacts.javafx.model.mock.ContextModel();
					new contacts.javafx.model.standard.ContextModel( contextService );

			managerGui =
					new contacts.javafx.view.ManagerGuiClassic( contextModel );

	    	Runtime.getRuntime().addShutdownHook(new Thread(
	    		() -> {
	    			try {

		    			// JDBC
	    				if ( dataSource != null ) {
							dataSource.closeConnection();
	    				}

						logger.config( "\n    Fermeture de l'application" );

	    			} finally {
	    				LogManagerSpecial.resetFinally();
	    			}
	    	    }
	    	));


	    	// Trace

	    	StringBuilder sbMessage = new StringBuilder();
	    	if ( contextDao != null ) {
	    		sbMessage.append( "\n    contextDao     : " ).append( contextDao.getClass().getName() );
	    	}
	    	if ( contextService != null ) {
	    		sbMessage.append( "\n    contextService : " ).append( contextService.getClass().getName() );
	    	}
	    	if ( contextModel != null ) {
	    		sbMessage.append( "\n    contextModel   : " ).append( contextModel.getClass().getName() );
	    	}
	    	if ( managerGui != null ) {
	    		sbMessage.append( "\n    managerGui     : " ).append( managerGui.getClass().getName() );
	    	}
			logger.log(Level.CONFIG, sbMessage.toString() );


			// D�marre l'application
			managerGui.launch();

		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Impossible de d�marrer l'application.", "", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
    }


    // M�thodes auxiliaires

	private static void configurerLogging() {
    	try {
        	InputStream in = MainContacts.class.getResourceAsStream("/META-INF/logging.properties");
        	LogManager logManager = LogManagerSpecial.getLogManager();
			logManager.readConfiguration( in );
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Types auxiliaires

    public static class LogManagerSpecial extends LogManager {
    	static LogManagerSpecial instance;
    	public LogManagerSpecial() {
        	instance = this;
        }
        @Override
        public void reset() {
        }
        private void reset0() {
        	super.reset();
        }
        public static void resetFinally() {
        	instance.reset0();
        }
    }

    // Initialise la property au chargement de la classe
    static {
        System.setProperty("java.util.logging.manager", LogManagerSpecial.class.getName());
    }


}