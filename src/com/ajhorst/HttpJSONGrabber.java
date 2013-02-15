package com.ajhorst;

public class HttpJSONGrabber {

	public static void main(String[] args){
		
		// or whatever URL points to a valid JSON. Use http://jsonlint.com/ to check
		String url = "http://imadeit.nu/CodeRed/person.json";
		HttpJSONGetter getter = HttpJSONGetter.createBasicGetter(url);
		
		Person aj = getter.<Person>getClassFromJSON(Person.class);
		
		System.out.println(aj.toString());
	}
}

/*
 * Test class for our getter
 */

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
