package dk.roninit.remedy

import javax.servlet.ServletOutputStream

class ImageRestController {

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
}
