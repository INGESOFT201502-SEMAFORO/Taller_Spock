package testingpractice


import grails.test.mixin.*
import spock.lang.*

@TestFor(EstudianteController)
@Mock(Estudiante)
class EstudianteControllerSpec extends Specification {
	
	void "El método numeroDeInstancias debe volver la cantidad de objetos creados del modelo Estudiante" (){
		when:
			def estudiante = new Estudiante(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 24,
				genero : "F",
				cedula : 1001,
				semestre: 1,
				codigoInst: 14,
			).save(flush:true, failOnError:true)
			def estudiante2 = new Estudiante(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 24,
				genero : "F",
				cedula : 1002,
				semestre: 1,
				codigoInst: 15,
			).save(flush:true, failOnError:true)
		then:
			controller.numeroDeInstancias() == 2
	}


}
