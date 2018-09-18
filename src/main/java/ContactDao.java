import java.util.*;

public class ContactDao implements IContactDao {
	private List <Contact> contacts;
	
	public ContactDao(){
		this.contacts = new ArrayList<Contact>();
	}

	
	/* (non-Javadoc)
	 * @see IContactDao#readAll()
	 */
	@Override
	public List<Contact> readAll(){
		return this.contacts;
	}
	
	/* (non-Javadoc)
	 * @see IContactDao#findByName(java.lang.String)
	 */
	@Override
	public Contact findByName(String name){
		Contact contactFind = null;
		if(name != null){
		
				for(int i = 0; i< contacts.size(); i++){
					if(contacts.get(i).getName().equals(name)){
						contactFind = contacts.get(i);
					}
				}
			
		}
		return contactFind;	
	}
	
	/* (non-Javadoc)
	 * @see IContactDao#add(Contact)
	 */
	@Override
	public void add(Contact contact){
		if (contact != null ){
			if(contact.getName()!= null){
				if(contacts.size()== 0){
					contacts.add(contact);
				}
				else if (findByName(contact.getName()) == null){
					contacts.add(contact);
				}
				else{
					System.out.println("Le contact existe deja");
				}
			}
			
		}else{
			System.out.println("Le contact est null");
		}
	}
	
	public void delete(Contact contact){
		if (contact != null ){
			if(contact.getName()!= null){
				if (findByName(contact.getName()) != null){
					contacts.remove(contact);
				}
				else{
					System.out.println("Le contact n'éxiste pas");
				}
			}
			
		}else{
			System.out.println("Le contact est null");
		}
	}
}
