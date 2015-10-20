package testingpractice
import grails.test.mixin.TestFor
import spock.lang.Specification

class UsuarioSpec extends Specification {

    void "El nombre del usuario no puede ser null"() {
		when : 
			def user = new Usuario(
				nombre : null,
				apellido : "Silva",
				edad : 24,
				genero : "F",
				cedula : 1,
			)
		then : 
			!user.validate()
    }
	
	void "El nombre del usuario debe tener minimo tres caracteres"(){
		when : 
			def user = new Usuario(
				nombre : "An",
				apellido : "Silva",
				edad : 24,
				genero : "F",
				cedula : 2,
			)
		then : 
			!user.validate()
	}
	
	void "El nombre el usuario debe tener máximo de 50 caracteres"(){
		when : 
			def user = new Usuario(
				nombre : "01234567890123456789012345678901234567890123456789",
				apellido : "Silva",
				edad : 24,
				genero : "F",
				cedula : 3,
			)
		then : 
			user.validate()
    }
	
	void "El apellido del usuario no puede ser nulo"() {
		when : 
			def user = new Usuario(
				nombre : "Cesar",
				apellido : null,
				edad : 24,
				genero : "F",
				cedula : 4,
			)
		then :
			!user.validate()
	}
	
	void "El apellido del usuario debe tener minimo tres caracteres"(){
		when : 
			def user = new Usuario(
				nombre : "Cesar",
				apellido : "Jua",
				edad : 24,
				genero : "F",
				cedula : 5,
			)
		then : 
			user.validate()
	}
	
	void "El apellido del usuario debe tener minimo 50 caracteres"(){
		when : 
			def user = new Usuario(
				nombre : "Cesar",
				apellido : "01234567890123456789012345678901234567890123456789A",
				edad : 24,
				genero : "F",
				cedula : 6,
			)
		then : 
			!user.validate()
	}
	
	void "El Usuario debe tener una edad mínima de 18"(){
		when :
			def user = new Usuario(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 17,
				genero : "F",
				cedula : 7,
			)
		then :
			!user.validate()
	}
	
	void "El género del usuario debe tener una sola letra"(){
		when :
			def user = new Usuario(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 18,
				genero : "FA",
				cedula : 8,
			)
		then :
			!user.validate()
	}
	
	void "El género del usuario debe ser M o F"(){
		when :
			def user = new Usuario(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 18,
				genero : "M",
				cedula : 9,
			)
		then :
			user.validate()
	}
	
	void "La cedula del usuario debe ser unica"(){
		when :
			def user = new Usuario(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 18,
				genero : "F",
				cedula : 1234,
			).save(flush:true, failOnError:true)
			def user2 = new Usuario(
				nombre : "Cesar",
				apellido : "Silva",
				edad : 18,
				genero : "F",
				cedula : 1234,
			)
		then :
			!user2.validate()
	}
}
