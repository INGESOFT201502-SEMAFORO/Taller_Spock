package testingpractice
import groovy.json.*

class Profesor extends Usuario{

    int oficina

    static hasMany =  [cursos:Curso ] 

    static constraints = {
        oficina min: 1, max: 50,unique: true
		//Arreglo curso nullable: false
    }
	String toString() {
		return "Oficina: " + oficina
	}
}
