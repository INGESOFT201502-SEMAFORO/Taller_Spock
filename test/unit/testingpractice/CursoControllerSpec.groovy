package testingpractice


import grails.test.mixin.*
import spock.lang.*

@TestFor(CursoController)
@Mock(Curso)
class CursoControllerSpec extends Specification {
	/*void "index"() {
		when:
			controller.index()

		then:
			view == '/curso/index'
	}*/
	void "El método numeroDeInstancias debe volver la cantidad de objetos creados del modelo Curso" (){
		when:
			def curso1 = new Curso(
				codigo: 8,
				nombrecurso : "Software2",
				creditos : 4,
				descripcion : "Compleja e importante",
				profesor : new Profesor()
			).save(flush:true, failOnError:true)
			def curso2 = new Curso(
				codigo: 9,
				nombrecurso : "Software2",
				creditos : 4,
				descripcion : "Compleja e importante",
				profesor : new Profesor()
			).save(flush:true, failOnError:true)
		then:
			controller.numeroDeInstancias() == 2
	}

}
