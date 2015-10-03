package remedyadminapp



import grails.test.mixin.*
import spock.lang.*

@TestFor(RemedyController)
@Mock(Remedy)
class RemedyControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.remedyInstanceList
            model.remedyInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.remedyInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def remedy = new Remedy()
            remedy.validate()
            controller.save(remedy)

        then:"The create view is rendered again with the correct model"
            model.remedyInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            remedy = new Remedy(params)

            controller.save(remedy)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/remedy/show/1'
            controller.flash.message != null
            Remedy.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def remedy = new Remedy(params)
            controller.show(remedy)

        then:"A model is populated containing the domain instance"
            model.remedyInstance == remedy
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def remedy = new Remedy(params)
            controller.edit(remedy)

        then:"A model is populated containing the domain instance"
            model.remedyInstance == remedy
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/remedy/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def remedy = new Remedy()
            remedy.validate()
            controller.update(remedy)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.remedyInstance == remedy

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            remedy = new Remedy(params).save(flush: true)
            controller.update(remedy)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/remedy/show/$remedy.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/remedy/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def remedy = new Remedy(params).save(flush: true)

        then:"It exists"
            Remedy.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(remedy)

        then:"The instance is deleted"
            Remedy.count() == 0
            response.redirectedUrl == '/remedy/index'
            flash.message != null
    }
}
