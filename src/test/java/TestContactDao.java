
public class TestContactDao {

	public static void main(String[] args) {
		System.out.println("Test de ContactDao");
		testAdd();
		testDelete();
	}
	
	public static void testAdd(){
		IContactDao contact = new ContactDao();	
		
		System.out.println("\nCas d'erreur : le String est null");
		Contact c1 = new Contact(null);
		contact.add(c1);
		
		System.out.println("la taille de la liste est : "+ contact.readAll().size());
		
	
		System.out.println("\nCas d'erreur : la taille du String est inférieur a 3 ");
		Contact c2 = new Contact("a");
		contact.add(c2);
		
		System.out.println("la taille de la liste est : "+ contact.readAll().size());
		
		System.out.println("\nCas d'erreur : la taille du String est supérieur a 40 ");
		Contact c3 = new Contact("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		contact.add(c3);
		
		System.out.println("la taille de la liste est : "+ contact.readAll().size());
		
		
		Contact c4 = new Contact("toto");
		contact.add(c4);
		
		System.out.println("\nCas d'erreur : le contact existe déjà ");
		Contact c5 = new Contact("toto");
		contact.add(c5);
		System.out.println("la taille de la liste est : "+ contact.readAll().size());
		
		

	}
	
	public static void testDelete(){
		IContactDao contact = new ContactDao();	
		System.out.println("\nCas d'erreur : le contact a supprimer n'est pas dans la liste ");
		Contact c6 = new Contact("titi");
		contact.delete(c6);
	}
}
