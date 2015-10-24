import remedyadminapp.Remedy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_remedyAdminApp_bck_remedyshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bck_remedy/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'remedy.label', default: 'Remedy'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (remedyInstance?.photo)) {
printHtmlPart(14)
expressionOut.print(createLink(controller:'remedy', action:'avatar_image', id:remedyInstance.id))
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (remedyInstance?.area)) {
printHtmlPart(17)
invokeTag('message','g',35,['code':("remedy.area.label"),'default':("Area")],-1)
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(remedyInstance?.area?.encodeAsHTML())
})
invokeTag('link','g',37,['controller':("area"),'action':("show"),'id':(remedyInstance?.area?.id)],3)
printHtmlPart(19)
}
printHtmlPart(16)
if(true && (remedyInstance?.description)) {
printHtmlPart(20)
invokeTag('message','g',44,['code':("remedy.description.label"),'default':("Description")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',46,['bean':(remedyInstance),'field':("description")],-1)
printHtmlPart(19)
}
printHtmlPart(16)
if(true && (remedyInstance?.errorType)) {
printHtmlPart(22)
invokeTag('message','g',53,['code':("remedy.errorType.label"),'default':("Error Type")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(remedyInstance?.errorType?.encodeAsHTML())
})
invokeTag('link','g',55,['controller':("errorType"),'action':("show"),'id':(remedyInstance?.errorType?.id)],3)
printHtmlPart(19)
}
printHtmlPart(16)
if(true && (remedyInstance?.machine)) {
printHtmlPart(24)
invokeTag('message','g',62,['code':("remedy.machine.label"),'default':("Machine")],-1)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(remedyInstance?.machine?.encodeAsHTML())
})
invokeTag('link','g',64,['controller':("machine"),'action':("show"),'id':(remedyInstance?.machine?.id)],3)
printHtmlPart(19)
}
printHtmlPart(16)
if(true && (remedyInstance?.status)) {
printHtmlPart(26)
invokeTag('message','g',71,['code':("remedy.status.label"),'default':("Status")],-1)
printHtmlPart(27)
createTagBody(3, {->
expressionOut.print(remedyInstance?.status?.encodeAsHTML())
})
invokeTag('link','g',73,['controller':("status"),'action':("show"),'id':(remedyInstance?.status?.id)],3)
printHtmlPart(19)
}
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createTagBody(3, {->
invokeTag('message','g',81,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',81,['class':("edit"),'action':("edit"),'resource':(remedyInstance)],3)
printHtmlPart(30)
invokeTag('actionSubmit','g',82,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(31)
})
invokeTag('form','g',84,['url':([resource:remedyInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443726932000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
