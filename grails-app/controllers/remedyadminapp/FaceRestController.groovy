package remedyadminapp

import grails.converters.JSON
import grails.rest.RestfulController

/**
 * Created with IntelliJ IDEA.
 * User: kasper
 * Date: 18/09/15
 * Time: 20.10
 * To change this template use File | Settings | File Templates.
 *
 */
// curl -H "Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/faceRest/index

// curl -H "Content-Type: application/json" -X POST -d '{"message":"face2", "noseId" : 1}' http://localhost:8080/RemedyAdminApp/faceRest/save

// curl -H "Content-Type: application/json" -X PUT -d '{"message":"face3", "noseId" : 1, "faceId" : 1}' http://localhost:8080/RemedyAdminApp/faceRest/update


class FaceRestController extends RestfulController {
    static responseFormats = ['json', 'xml']

    FaceRestController() {
        super(Face)
    }

    def index() {
        println "index"
        respond Face.list()
    }

    def show(Integer id) {
        println "show"
        respond Face.get(id)
    }


    def save(CreateFaceDetails face) {
        println "save ${face.errors}"
        if (!face.hasErrors()) {
        //    def user = springSecurityService.currentUser
            Nose nose = Nose.findById face.noseId
            def newFace = new Face(name: face.message, nose: nose)

          //  def newPost = postService.createPost(
            //        user.loginId,
             //       post.message)
            newFace = newFace.save(flush: true)
            respond newFace, status: 201
        }
        else {
            respond face
        }
    }


    def update(UpdateFaceDetails updateFaceDetails) {
        println "update ${updateFaceDetails.errors}"
        if (!updateFaceDetails.hasErrors()) {
            Face face = Face.get(updateFaceDetails.faceId)

            if (!face) {
                respond status: 404
                return
            }
            Nose nose = Nose.findById updateFaceDetails.noseId

            face.name = updateFaceDetails.message
            face.nose = nose
            face.validate() && face.save()
            respond face
        }
        else {
            respond postDetails
        }
    }



}

class CreateFaceDetails {
    String message
    Long noseId

    static constraints = {
        message blank: false, nullable: false
    }
}

class UpdateFaceDetails {
    Long faceId
    String message
    Long noseId

    static constraints = {
        message blank: false, nullable: false
        faceId blank: false, nullable: false
        noseId blank: false, nullable: false
    }
}
