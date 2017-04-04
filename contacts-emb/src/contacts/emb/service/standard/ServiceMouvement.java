package contacts.emb.service.standard;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import contacts.commun.dto.DtoAnnonceur;
import contacts.commun.dto.DtoMouvement;
import contacts.commun.service.IServiceMouvement;
import contacts.commun.util.ExceptionAnomalie;
import contacts.commun.util.ExceptionAppli;
import contacts.emb.dao.IDaoAnnonceur;
import contacts.emb.dao.IDaoMouvement;
import contacts.emb.dao.IManagerTransaction;
import contacts.emb.dom.Annonceur;
import contacts.emb.dom.Mouvement;
import contacts.emb.util.mapper.IMapperDoDto;
import contacts.emb.util.securite.IManagerSecurite;

public class ServiceMouvement implements IServiceMouvement {

	// Logger
		private static final Logger logger = Logger.getLogger(ServiceMouvement.class.getName());


		// Champs

		private IManagerSecurite managerSecurite;

		private IDaoMouvement daoMouvement;
		private IMapperDoDto mapper;
		private IManagerTransaction managerTransaction;

		// Injecteurs

		public void setManagerSecurite(IManagerSecurite managerSecurite) {
			this.managerSecurite = managerSecurite;
		}

		public void setManagerTransaction(IManagerTransaction managerTransaction) {
			this.managerTransaction = managerTransaction;
		}

		public void setMapper( IMapperDoDto mapper ) {
			this.mapper = mapper;
		}

		public void setDaoMouvement(IDaoMouvement daoMouvement) {
			this.daoMouvement = daoMouvement;
		}


	@Override
	public int inserer(DtoMouvement dtoMouvement) throws ExceptionAppli {
		// TODO Auto-generated method stub
		try {
			managerSecurite.verifierAutorisationSecretaire();

			managerTransaction.begin();
			try {
				int id = daoMouvement.inserer( mapper.map( dtoMouvement ) );
				managerTransaction.commit();
				return id;
			} catch (Exception e) {
				managerTransaction.rollback();
				throw e;
			}

		} catch (RuntimeException e) {
			logger.log( Level.SEVERE, e.getMessage(), e );
			throw new ExceptionAnomalie(e);
		}
	}

	@Override
	public void modifier(DtoMouvement dtoMouvement) throws ExceptionAppli {
		// TODO Auto-generated method stub
		try {

			managerSecurite.verifierAutorisationSecretaire();

			managerTransaction.begin();
			try {
				daoMouvement.modifier( mapper.map( dtoMouvement ) );
				managerTransaction.commit();
			} catch (Exception e) {
				managerTransaction.rollback();
				throw e;
			}

		} catch (RuntimeException e) {
			logger.log( Level.SEVERE, e.getMessage(), e );
			throw new ExceptionAnomalie(e);
		}
	}

	@Override
	public void supprimer(int idMouvement) throws ExceptionAppli {
		// TODO Auto-generated method stub
		try {

			managerSecurite.verifierAutorisationSecretaire();

			managerTransaction.begin();
			try {
				daoMouvement.supprimer(idMouvement);
				managerTransaction.commit();
			} catch (Exception e) {
				managerTransaction.rollback();
				throw e;
			}

		} catch (RuntimeException e) {
			logger.log( Level.SEVERE, e.getMessage(), e );
			throw new ExceptionAnomalie(e);
		}
	}

	@Override
	public DtoAnnonceur retrouver(int idMouvement) throws ExceptionAppli {
		// TODO Auto-generated method stub
		try {
//			managerSecurite.verifierAutorisationUtilisateurOuAdmin();
//			return mapPersonnes.get(idPersonne);
			return mapper.map(daoMouvement.retrouver(idMouvement));
		} catch (RuntimeException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new ExceptionAnomalie(e);
		}
	}

	@Override
	public List<DtoMouvement> listerTout() throws ExceptionAppli {
		// TODO Auto-generated method stub
		try {

			List<DtoMouvement> mouvements = new ArrayList<>();
			for( Mouvement mouvement : daoMouvement.listerTout() ) {
				mouvements.add( mapper.map( mouvement ) );
			}
			return mouvements;

		} catch (RuntimeException e) {
			logger.log( Level.SEVERE, e.getMessage(), e );
			throw new ExceptionAnomalie(e);
		}
	}

}
