package testingpractice
import groovy.json.*
class Curso {

    long codigo
    String nombrecurso
    int creditos
    String descripcion


    static belongsTo = [profesor: Profesor]

    static constraints = {
        codigo unique: true
        nombrecurso size: 3..50, nullable: false
        creditos min: 1, max: 5
        descripcion blank: false, nullable: false, minSize: 10
    }
	
	String toString() {
		return "Código: " + codigo +" Nombre Curso: " + nombrecurso +" Creditos: " + creditos +" Descripción: " + descripcion
	}
}
