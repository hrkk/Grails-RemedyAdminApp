package remedyadminapp

import javax.servlet.ServletOutputStream

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RemedyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Remedy.list(params), model: [remedyInstanceCount: Remedy.count()]
    }

    def show(Remedy remedyInstance) {
        respond remedyInstance
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

    def create() {
        respond new Remedy(params)
    }

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

        /*
        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'remedyInstance.label', default: 'Remedy'), remedyInstance.id])
                redirect remedyInstance
            }
            '*' { respond remedyInstance, [status: CREATED] }
        }
        */
        flash.message = message(code: 'default.created.message', args: [message(code: 'remedyInstance.label', default: 'Remedy'), remedyInstance.id])
        redirect(action:'show')
    }

    def edit(Remedy remedyInstance) {
        respond remedyInstance
    }

    @Transactional
    def update(Remedy remedyInstance) {
        if (remedyInstance == null) {
            notFound()
            return
        }

        if (remedyInstance.hasErrors()) {
            respond remedyInstance.errors, view: 'bck_edit'
            return
        }

        remedyInstance.save flush: true



        flash.message = message(code: 'default.updated.message', args: [message(code: 'Remedy.label', default: 'Remedy'), remedyInstance.id])
        redirect(action:'index')
    }

    @Transactional
    def delete(Remedy remedyInstance) {

        if (remedyInstance == null) {
            notFound()
            return
        }

        remedyInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Remedy.label', default: 'Remedy'), remedyInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'remedyInstance.label', default: 'Remedy'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
