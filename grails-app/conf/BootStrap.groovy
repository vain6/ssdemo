import com.ssdemo.auth.*

class BootStrap {

    def init = { servletContext ->
		
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
		def user = new User(username: 'someone@somemail.com', password: 'password',
			firstName: 'John', lastName: 'Doe', emailAddress: 'someone@somemail.com').save(flush: true)
		
		UserRole.create user, adminRole, true
		
		assert User.count() == 1
		assert Role.count() == 2
		assert UserRole.count() == 1
    }
    def destroy = {
    }
}
