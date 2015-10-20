package testingpractice
import grails.test.mixin.TestFor
import spock.lang.Specification


class ProfesorSpec extends Specification {

	void "Oficinas enumeradas del 1 al 50"() {
		when :
			def profesor = new Profesor(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 18,
				genero : "F",
				cedula : 185,
				oficina : 0
			)
		then :
			!profesor.validate()
	}
	
	void "Número de oficina único por cada profesor"() {
		when :
			def profesor = new Profesor(
				
				nombre : "Cesar",
				apellido : "Silva",
				edad : 18,
				genero : "F",
				cedula : 16,
				oficina : 1).save(flush:true, failOnError:true)
			def profesor2 = new Profesor(
				
				nombre : "Cesar",
				apellido : "Silva",
				edad : 18,
				genero : "F",
				cedula : 17,
				oficina : 1,)
		then :
			!profesor2.validate()
	}
}
