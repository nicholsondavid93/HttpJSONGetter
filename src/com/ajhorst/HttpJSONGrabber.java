package com.ajhorst;

public class HttpJSONGrabber {

	public static void main(String[] args){
		String url = "http://imadeit.nu/CodeRed/person.json";
		HttpJSONGetter getter = HttpJSONGetter.createBasicGetter(url);
		
		Person aj = getter.<Person>getClassFromJSON(Person.class);
		
		System.out.println(aj.toString());
	}
}

class Person{
	private String name;
	private Integer age;
	private String favorite_pokemon;
	
	public Person(){}
	
	public String toString(){
		return "Ich heisse " + name + 
				", ich bin " + age + 
				" Jahre alt, und mein Lieblingspokemon ist " + favorite_pokemon;
	}
}
