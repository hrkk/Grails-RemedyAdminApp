import remedyadminapp.Remedy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_remedyAdminApp_bck_remedybck_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bck_remedy/bck_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: remedyInstance, field: 'photo', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("remedy.photo.label"),'default':("Photo")],-1)
printHtmlPart(2)
expressionOut.print(createLink(controller:'remedy', action:'avatar_image', id:remedyInstance.id))
printHtmlPart(3)
expressionOut.print(hasErrors(bean: remedyInstance, field: 'area', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("remedy.area.label"),'default':("Area")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['id':("area"),'name':("area.id"),'from':(remedyadminapp.Area.list()),'optionKey':("id"),'required':(""),'value':(remedyInstance?.area?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: remedyInstance, field: 'description', 'error'))
printHtmlPart(7)
invokeTag('message','g',24,['code':("remedy.description.label"),'default':("Description")],-1)
printHtmlPart(8)
invokeTag('textField','g',27,['name':("description"),'value':(remedyInstance?.description)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: remedyInstance, field: 'errorType', 'error'))
printHtmlPart(9)
invokeTag('message','g',32,['code':("remedy.errorType.label"),'default':("Error Type")],-1)
printHtmlPart(5)
invokeTag('select','g',35,['id':("errorType"),'name':("errorType.id"),'from':(remedyadminapp.ErrorType.list()),'optionKey':("id"),'required':(""),'value':(remedyInstance?.errorType?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: remedyInstance, field: 'machine', 'error'))
printHtmlPart(10)
invokeTag('message','g',40,['code':("remedy.machine.label"),'default':("Machine")],-1)
printHtmlPart(5)
invokeTag('select','g',43,['id':("machine"),'name':("machine.id"),'from':(remedyadminapp.Machine.list()),'optionKey':("id"),'required':(""),'value':(remedyInstance?.machine?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: remedyInstance, field: 'status', 'error'))
printHtmlPart(11)
invokeTag('message','g',48,['code':("remedy.status.label"),'default':("Status")],-1)
printHtmlPart(5)
invokeTag('select','g',51,['id':("status"),'name':("status.id"),'from':(remedyadminapp.Status.list()),'optionKey':("id"),'required':(""),'value':(remedyInstance?.status?.id),'class':("many-to-one")],-1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443643235000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
