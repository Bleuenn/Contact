
public class ContactService {
	private IContactDao dao = new ContactDao();
	
	public void add (String contactName) throws ContactExistException{
		if(contactName == null){
			// Exception 
			throw new IllegalAccessError("Name can't be null");
		}
		
		Contact contact = this.dao.findByName(contactName);
		if(contact != null){
			throw new ContactExistException("Contact "+contactName+" already exists");
		}
		
		contact = new Contact(contactName);
		this.dao.add(contact);
	}
	
	public void delete (String contactName) throws ContactExistException{
		if(contactName == null){
			// Exception 
			throw new IllegalAccessError("Name can't be null");
		}
		
		Contact contact = this.dao.findByName(contactName);
		if(contact == null){
			throw new ContactExistException("Contact "+contactName+" does not exist");
		}
		this.dao.delete(contact);
	}
}

