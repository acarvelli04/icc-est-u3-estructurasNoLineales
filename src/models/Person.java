package models;
public class Person implements Comparable<Person> {

    private String nombre;
    private int edad;

    public Person(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "\n Person [nombre=" + nombre + ", edad=" + edad + "]"; 
        
    }

    @Override
    public int compareTo(Person otra) {
       
        int resultComp= Integer.compare(this.edad, otra.getEdad());
        if (resultComp !=0){
            return resultComp;
        }
        return this.nombre.compareTo(otra.getNombre());
    }

    

    
    
}
