package application.model;

import java.io.Serializable;

public class Futar implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
    int id;
    String name;
    int age;
 
    public Futar(){
    }
 
    public Futar(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public Futar(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

	@Override
	public String toString() {
		return "Futár [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
 
}
