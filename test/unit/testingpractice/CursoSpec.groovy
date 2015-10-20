package testingpractice
import grails.test.mixin.TestFor
import spock.lang.Specification


class CursoSpec extends Specification {
	void "El nombre del curso no puede ser null"() {
		when : 
			def curso = new Curso(
				codigo: 2,
				nombrecurso : null,
				creditos : 4,
				descripcion : "Compleja e importante",
			)
		then : 
			!curso.validate()
    }
	
	void "El nombre del curso debe tener minimo tres caracteres"(){
		when : 
			def curso = new Curso(
				codigo: 3,
				nombrecurso : "Mat",
				creditos : 4,
				descripcion : "Compleja e importante",
			)
		then : 
			!curso.validate()
	}
	
	void "El nombre el curso debe tener máximo de 50 caracteres"(){
		when : 
			def curso = new Curso(
				
				codigo: 4,
				nombrecurso : "01234567890123456789012345678901234567890123456789",
				creditos : 4,
				descripcion : "Compleja e importante",
			)
		then : 
			!curso.validate()
    }

	void "Los creditos del curso debe ser minimo 1"(){
		when : 
			def curso = new Curso(
				codigo: 5,
				nombrecurso : "Matematicas",
				creditos : 0,
				descripcion : "Compleja e importante",
			)
		then : 
			!curso.validate()
	}
	
	void "Los creditos del curso debe ser máximo 5"(){
		when :
			def curso = new Curso(
				codigo: 6,
				nombrecurso : "Matematicas",
				creditos : 6,
				descripcion : "Compleja e importante",
			)
		then :
			!curso.validate()
	}
	
	void "Todo curso tiene una descripción obligatoria"(){
		when :
			def curso = new Curso(
				codigo: 7,
				nombrecurso : "Matematicas",
				creditos : 4,
				descripcion : "",
			)
		then :
			!curso.validate()
	}
	
	
	void "La descripción debe contener mínimo 10 caracteres"(){
		when :
			def curso = new Curso(
				codigo: 7,
				nombrecurso : "Matematicas",
				creditos : 4,
				descripcion : "123456789",
			)
		then :
			!curso.validate()
	}

}
