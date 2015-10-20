package testingpractice
import grails.test.mixin.*
import spock.lang.*

@TestFor(UsuarioController)
@Mock(Usuario)
class UsuarioControllerSpec extends Specification {

	void "El método numeroDeInstancias debe volver la cantidad de objetos creados del modelo Usuario" (){
		when:
			def user = new Usuario(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 18,
				genero : "F",
				cedula : 12345678,
			).save(flush:true, failOnError:true)
			def user2 = new Usuario(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 18,
				genero : "F",
				cedula : 123456789,
			).save(flush:true, failOnError:true)
		then:
			controller.numeroDeInstancias() == 2
	}
	
}
