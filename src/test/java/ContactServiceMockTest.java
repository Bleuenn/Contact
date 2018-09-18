import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

public class ContactServiceMockTest extends EasyMockSupport{

	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	
	@TestSubject
	private ContactService service = new ContactService();
	
	@Mock
	private IContactDao contactDao;
	
	@Test(expected = ContactExistException.class)
	public void testAddContact() throws ContactExistException {
		//1 - Enregistrement des comportements de mocks
		EasyMock.expect(contactDao.findByName("toto")).andReturn(new Contact());
		//2 - Fin d'enregistrement
		replayAll();
		//3 - Test
		service.add("toto");
	}
	@Test(expected = ContactExistException.class)
	public void testDeleteContactUnexists() throws ContactExistException {
		//1 - Enregistrement des comportements de mocks
		EasyMock.expect(contactDao.findByName("UnexistedContact")).andReturn(null);
		//2 - Fin d'enregistrement
		replayAll();
		//3 - Test
		service.delete("UnexistedContact");
	}
	
	@Test
	public void testDeleteContactExists() throws ContactExistException {
		//1 - Enregistrement des comportements de mocks
		Contact contact = new Contact();
		contact.setName("ExistedContact");
		EasyMock.expect(contactDao.findByName(contact.getName())).andReturn(contact);
		contactDao.delete(contact);
		//2 - Fin d'enregistrement
		replayAll();
		//3 - Test
		service.delete(contact.getName());
	}
	
}
