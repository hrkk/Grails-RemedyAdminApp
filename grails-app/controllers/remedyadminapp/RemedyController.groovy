package remedyadminapp

import grails.transaction.Transactional

import javax.servlet.ServletOutputStream

class RemedyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    static scaffold = true

    def avatar_image() {
        def avatarUser = Remedy.get(params.id)
        if (!avatarUser || !avatarUser.photo) {
            response.sendError(404)
            return
        }
        response.contentType = "jpg"
        response.contentLength = avatarUser.photo.size()
        OutputStream out = response.outputStream
        out.write(avatarUser.photo)
        out.close()
    }

    def showImage(int id) {
        println "id ${id}"
        def remedy = Remedy.get(id)
        def arrayOfBytes = remedy.getPhoto()
        if(arrayOfBytes!=null) {
            response.setContentType("image/jpeg");
            response.setContentLength(arrayOfBytes.length);
            ServletOutputStream stream = response.getOutputStream();
            stream.write(arrayOfBytes);
            stream.flush();
        }
    }


    @Transactional
    def save(Remedy remedyInstance) {
        if (remedyInstance == null) {
            notFound()
            return
        }

        if (remedyInstance.hasErrors()) {
            respond remedyInstance.errors, view: 'bck_create'
            return
        }

        if(!remedyInstance.save(flush: true))
            println "ERROR ved savbe"

//
//        request.withFormat {
//            form {
//                flash.message = message(code: 'default.created.message', args: [message(code: 'remedyInstance.label', default: 'Remedy'), remedyInstance.id])
//                redirect remedyInstance
//            }
//            '*' { respond remedyInstance, [status: CREATED] }
//        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'remedyInstance.label', default: 'Remedy'), remedyInstance.id])
        redirect(action:'show')
    }
}
