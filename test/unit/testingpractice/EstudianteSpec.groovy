package testingpractice
import grails.test.mixin.TestFor
import spock.lang.Specification


class EstudianteSpec extends Specification {


    void "El semestre mínimo de un estudiante es 1 "() {
		when : 
			def estudiante = new Estudiante(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 24,
				genero : "F",
				cedula : 10,
				semestre: 0,
				codigoInst: 1,
			)
		then : 
			!estudiante.validate()
    }
	
	void "El semestre máximo de un estudiante es 20"() {
		when : 
			def estudiante = new Estudiante(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 24,
				genero : "F",
				cedula : 11,
				semestre: 21,
				codigoInst: 2,
			)
		then : 
			!estudiante.validate()
    }
	
	void "El código institucional de un estudiante debe ser único"(){
		when :
			def estudiante = new Estudiante(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 24,
				genero : "F",
				cedula : 12,
				semestre: 1,
				codigoInst: 3,
			).save(flush:true, failOnError:true)
			def estudiante2 = new Estudiante(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 24,
				genero : "F",
				cedula : 13,
				semestre: 2,
				codigoInst: 3,
			)
		then :
			!estudiante2.validate()
	}
	
	void "El código institucional de un estudiante no puede ser nulo"() {
		when :
			def estudiante = new Estudiante(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 24,
				genero : "F",
				cedula : 14,
				semestre: 2,
				codigoInst: null,
			)
		then :
			!estudiante.validate()
	}
	
	void "Cuando se crea un estudiante, la lista que representa sus cursos debe inicializarse y no ser nula"() {
		when :
			def estudiante = new Estudiante(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 24,
				genero : "F",
				cedula : 15,
				semestre: 2,
				codigoInst: 62,
				
			)
		then :
			estudiante.cursos instanceof ArrayList
	}
}
