package contacts.emb.service.standard;

import java.util.logging.Level;

import contacts.commun.dto.DtoRubrique;
import contacts.commun.service.IServiceRubrique;
import contacts.commun.util.ExceptionAnomalie;
import contacts.commun.util.ExceptionAppli;
import contacts.commun.util.ExceptionValidation;
import contacts.emb.dao.IDaoRubrique;
import contacts.emb.dao.IManagerTransaction;
import contacts.emb.util.mapper.IMapperDoDto;
import contacts.emb.util.securite.IManagerSecurite;
import java.util.List;
import java.util.logging.Logger;



public class ServiceRubrique implements IServiceRubrique{
	// Logger
			private static final Logger logger = Logger.getLogger(ServicePersonne.class.getName());

			// Champs

			// private Donnees donnees;
			// private Map<Integer, DtoPersonne> mapPersonnes;

			private IManagerSecurite managerSecurite;

			private IDaoRubrique daoRubrique;
			private IMapperDoDto mapper;
			private IManagerTransaction managerTransaction;

			public void setManagerSecurite(IManagerSecurite managerSecurite) {
				this.managerSecurite = managerSecurite;
			}
			
			// Actions

			@Override
			public int inserer(DtoRubrique dtoRubrique) throws ExceptionAppli {
				try {
					managerSecurite.verifierAutorisationUtilisateurOuAdmin();
					verifierValiditeDonnees(dtoRubrique);
					// if ( mapPersonnes.isEmpty() ) {
					// dtoPersonne.setId( 1 );
					// } else {
					// dtoPersonne.setId( Collections.max( mapPersonnes.keySet() ) + 1
					// );
					// }
					// affecterIdTelephones(dtoPersonne);
					// mapPersonnes.put( dtoPersonne.getId(), dtoPersonne );
					// return dtoPersonne.getId();
					managerTransaction.begin();
					try {
						int id = daoRubrique.inserer(mapper.map(dtoRubrique));
						managerTransaction.commit();
						return id;
					} catch (Exception e) {
						managerTransaction.rollback();
						throw e;
					}
				} catch (RuntimeException e) {
					logger.log(Level.SEVERE, e.getMessage(), e);
					throw new ExceptionAnomalie(e);
				}

			}

			@Override
			public void modifier(DtoRubrique dtoRubrique) throws ExceptionAppli {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void supprimer(int idRubrique) throws ExceptionAppli {
				// TODO Auto-generated method stub
				
			}

			@Override
			public DtoRubrique retrouver(int idRubrique) throws ExceptionAppli {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<DtoRubrique> listerTout() throws ExceptionAppli {
				return null;
				// TODO Auto-generated method stub return null;
			}
			
			private void verifierValiditeDonnees(DtoRubrique dtoRubrique) throws ExceptionAppli {

				StringBuilder message = new StringBuilder();

				if (dtoRubrique.getNom() == null || dtoRubrique.getNom().isEmpty()) {
					message.append("\nLe nom est absent.");
				} else if (dtoRubrique.getNom().length() > 25) {
					message.append("\nLe nom est trop long.");
				}

			if (message.length() > 0) {
				throw new ExceptionValidation(message.toString().substring(1));
			}
		}	
	
	
	

}
