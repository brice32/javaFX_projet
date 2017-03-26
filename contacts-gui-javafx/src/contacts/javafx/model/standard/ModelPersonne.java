package contacts.javafx.model.standard;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import sun.rmi.runtime.Log;
import contacts.commun.dto.DtoCompte;
import contacts.commun.dto.DtoPersonne;
import contacts.commun.service.IServicePersonne;
import contacts.commun.util.ExceptionAppli;
import contacts.javafx.fxb.*;
import contacts.javafx.model.IModelPersonne;
import contacts.javafx.util.mapper.IMapperDtoFX;
import contacts.javafx.view.IManagerGui;
import contacts.commun.util.ExceptionAppli;;

public class ModelPersonne implements IModelPersonne {

	private final ObservableList<FXPersonne> personnes = FXCollections.observableArrayList(p ->new Observable[]{ p.nomProperty(), p.prenomProperty()});

	private final FXPersonne personneVue= new FXPersonne(99, "XXXXX", "Xxxxx");

	private static FXPersonne personneCourant = new FXPersonne();

	private IManagerGui managerGui;


	private IServicePersonne servicePersonne;

	private IMapperDtoFX mapper;
//	public ModelPersonne(){
//		actualiserListe();
//	}

	/* (non-Javadoc)
	 * @see contacts.javafx.model.mock.IModelPersonne#actualiserListe()
	 */
	@Override
	public void actualiserListe() throws ExceptionAppli{
		personnes.clear();

//		personnes.add(new FXPersonne(1,"DUBOIS","Jean"));
//		personnes.add(new FXPersonne(2,"DUPONT","Marie"));
//		personnes.add(new FXPersonne(3,"DURAND","Pierre"));
		for( DtoPersonne dto : servicePersonne.listerTout() ) {
		FXPersonne personne = mapper.map( dto );
			personnes.add(personne);
		}
	}

	/* (non-Javadoc)
	 * @see contacts.javafx.model.mock.IModelPersonne#getPersonnes()
	 */
	@Override
	public ObservableList<FXPersonne> getPersonnes() {
		// TODO Auto-generated method stub
		return personnes;
	}

	/* (non-Javadoc)
	 * @see contacts.javafx.model.mock.IModelPersonne#supprimer(contacts.javafx.fxb.FXPersonne)
	 */
	@Override
	public void supprimer(FXPersonne personne) throws ExceptionAppli{
		servicePersonne.supprimer(personne.getId());
		personnes.remove(personne);
	}

	/* (non-Javadoc)
	 * @see contacts.javafx.model.mock.IModelPersonne#getPersonneVue()
	 */
	@Override
	public FXPersonne getPersonneVue(){
		return personneVue;
	}

	// M��thodes auxiliaires
//	private FXPersonne copierDonnees( FXPersonne source, FXPersonne cible ) {
//	cible.setId( source.getId() );
//	cible.setNom( source.getNom() );
//	cible.setPrenom( source.getPrenom() );
//	cible.getTelephones().clear();
//	for(FXTelephone telephone : source.getTelephones()){
//		cible.getTelephones().add(telephone);
//	}
//	return cible ;
//	}

	/* (non-Javadoc)
	 * @see contacts.javafx.model.mock.IModelPersonne#preparerModifier(contacts.javafx.fxb.FXPersonne)
	 */
	@Override
	public void preparerModifier( FXPersonne personne ){
		if(personne!=null){
		personneCourant=personne;
//		copierDonnees(personne, personneVue);
		mapper.update(personne, personneVue);
		}
		else{
			personneCourant=new FXPersonne();
//			copierDonnees(personneCourant, personneVue);
			mapper.update(personneCourant, personneVue);
		}
	}

	/* (non-Javadoc)
	 * @see contacts.javafx.model.mock.IModelPersonne#preparerModifier()
	 */
	@Override
	public void preparerModifier(){
		personneCourant=new FXPersonne();
//		personnes.add(personneCourant);
//		copierDonnees(personneCourant, personneVue);
		mapper.update(personneCourant, personneVue);
	}

	/* (non-Javadoc)
	 * @see contacts.javafx.model.mock.IModelPersonne#ValiderMiseAJour()
	 */
	@Override
	public void ValiderMiseAJour( ) throws ExceptionAppli{
//		int dernierId;
		String message="";
		String Nom=personneVue.getNom();
		String Prenom=personneVue.getPrenom();
		if(Nom==null||Nom.length()==0){
			message+="Le nom de la personne ne doit pas etre vide.\n";
		}else if(Nom.length()>=25){
			message+="La longueur du nom ne doit pas exceder 25 caracteres.\n";
		}
		if(Prenom==null||Prenom.length()==0){
			message+="Le prenom de la personne ne doit pas etre vide.\n";
		}else if(Prenom.length()>=25){
			message+="La longueur du prenom ne doit pas exceder 25 caracteres..\n";
		}
		if(message.length()==0){
			if(personneVue.getId()==0){

			}

//			copierDonnees(personneVue, personneCourant);

//			if(!personnes.contains(personneCourant)){
			if(personneVue.getId()==0){
				/*������Щ����Ϊ���ܹ���ȷ�ĸ���ID��ֵ�������tm��mapper�ķ������Զ���Ū����*/
//				if(personnes.size()!=0){
//				dernierId=personnes.get(personnes.size()-1).getId();
//				personneCourant.setId(dernierId+1);
//				}
//				else{
//					personneCourant.setId(1);
//				}
//				personnes.add(personneCourant);
//				DtoPersonne dtopersonne = mapper.map(personneCourant);
//				servicePersonne.inserer(dtopersonne);
				int id = servicePersonne.inserer( mapper.map( personneVue ) );
				personneVue.setId( id );
				personnes.add(personneCourant);

			}else{
				servicePersonne.modifier(mapper.map( personneVue ));

			}
			mapper.update( mapper.map( servicePersonne.retrouver( personneVue.getId()) ), personneVue );
			mapper.update(personneVue, personneCourant);
		}else{
/*AlertType.ERROR
AlertType.WARNING
AlertType.INFORMATION*/
//			Main.afficherMessage(message, AlertType.ERROR);
//			managerGui.afficherErreur( message );
			throw new ExceptionAppli(message) {
			};
		}

	}


	/* (non-Javadoc)
	 * @see contacts.javafx.model.mock.IModelPersonne#ajouterTelephone()
	 */
	@Override
	public void ajouterTelephone(){
		personneVue.getTelephones().add(new FXTelephone());
	}

	/* (non-Javadoc)
	 * @see contacts.javafx.model.mock.IModelPersonne#supprimerTelephone(contacts.javafx.fxb.FXTelephone)
	 */
	@Override
	public void supprimerTelephone( FXTelephone telephone ){
		personneVue.getTelephones().remove(telephone);
	}

	// Initialisation
	/* (non-Javadoc)
	 * @see contacts.javafx.model.mock.IModelPersonne#refresh()
	 */
	@Override
	public void refresh() throws ExceptionAppli {
	 actualiserListe();
	}


	public void setServicePersonne(IServicePersonne servicePersonne) {
		this.servicePersonne = servicePersonne;
	}


	public void setMapper(IMapperDtoFX mapper) {
		this.mapper = mapper;
	}

}
