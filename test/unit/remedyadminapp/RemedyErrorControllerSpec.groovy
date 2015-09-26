package remedyadminapp



import grails.test.mixin.*
import spock.lang.*

@TestFor(RemedyErrorController)
@Mock(ErrorType)
class RemedyErrorControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.remedyErrorInstanceList
        model.remedyErrorInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.remedyErrorInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        def remedyError = new ErrorType()
        remedyError.validate()
        controller.save(remedyError)

        then: "The create view is rendered again with the correct model"
        model.remedyErrorInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        remedyError = new ErrorType(params)

        controller.save(remedyError)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/remedyError/show/1'
        controller.flash.message != null
        ErrorType.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def remedyError = new ErrorType(params)
        controller.show(remedyError)

        then: "A model is populated containing the domain instance"
        model.remedyErrorInstance == remedyError
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def remedyError = new ErrorType(params)
        controller.edit(remedyError)

        then: "A model is populated containing the domain instance"
        model.remedyErrorInstance == remedyError
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/remedyError/index'
        flash.message != null


        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def remedyError = new ErrorType()
        remedyError.validate()
        controller.update(remedyError)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.remedyErrorInstance == remedyError

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        remedyError = new ErrorType(params).save(flush: true)
        controller.update(remedyError)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/remedyError/show/$remedyError.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/remedyError/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def remedyError = new ErrorType(params).save(flush: true)

        then: "It exists"
        ErrorType.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(remedyError)

        then: "The instance is deleted"
        ErrorType.count() == 0
        response.redirectedUrl == '/remedyError/index'
        flash.message != null
    }
}
