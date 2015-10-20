package testingpractice
import grails.test.mixin.*
import spock.lang.*

@TestFor(ProfesorController)
@Mock(Profesor)
class ProfesorControllerSpec extends Specification {
	
	void "El método numeroDeInstancias debe volver la cantidad de objetos creados del modelo Profesor" (){
		when:
			def profesor = new Profesor(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 18,
				genero : "F",
				cedula : 991,
				oficina : 41,
			).save(flush:true, failOnError:true)
			def profesor2 = new Profesor(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 18,
				genero : "F",
				cedula : 992,
				oficina : 42,
			).save(flush:true, failOnError:true)
		then:
			controller.numeroDeInstancias() == 2
	}


}
