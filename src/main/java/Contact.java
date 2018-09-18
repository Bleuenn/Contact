public class Contact {
	private String name;
	
	public Contact(String name){
		if(name != null ){
			if (name.length() >= 3 && name.length()<=40){
				this.name = name;
			}else{
				System.out.println("Erreur : la taille du nom est inferieur a 3 ou supérieur a 40 ");
			}
		}
		else{
			System.out.println("Erreur : l'objet est null ");
		}
	}
	

	public Contact() {
		// TODO Auto-generated constructor stub
	}


	public String getName(){
		return this.name;
	}
	
	public void setName(String newName){
		this.name = newName;
	}

}
