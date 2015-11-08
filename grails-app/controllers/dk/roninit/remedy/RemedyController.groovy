package dk.roninit.remedy

import grails.plugin.springsecurity.annotation.Secured

import javax.servlet.ServletOutputStream

@Secured('ROLE_ADMIN')
class RemedyController {

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

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    static scaffold = Remedy

}
