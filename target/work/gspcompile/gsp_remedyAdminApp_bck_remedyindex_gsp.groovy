import remedyadminapp.Remedy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_remedyAdminApp_bck_remedyindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bck_remedy/index.gsp" }
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
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',27,['property':("photo"),'title':(message(code: 'remedy.photo.label', default: 'Photo'))],-1)
printHtmlPart(13)
invokeTag('message','g',29,['code':("remedy.area.label"),'default':("Area")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("description"),'title':(message(code: 'remedy.description.label', default: 'Description'))],-1)
printHtmlPart(13)
invokeTag('message','g',33,['code':("remedy.errorType.label"),'default':("Error Type")],-1)
printHtmlPart(15)
invokeTag('message','g',35,['code':("remedy.machine.label"),'default':("Machine")],-1)
printHtmlPart(15)
invokeTag('message','g',37,['code':("remedy.status.label"),'default':("Status")],-1)
printHtmlPart(16)
loop:{
int i = 0
for( remedyInstance in (remedyInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
expressionOut.print(createLink(controller:'remedy', action:'avatar_image', id:remedyInstance.id))
printHtmlPart(20)
})
invokeTag('link','g',46,['action':("show"),'id':(remedyInstance.id)],3)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: remedyInstance, field: "area"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: remedyInstance, field: "description"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: remedyInstance, field: "errorType"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: remedyInstance, field: "machine"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: remedyInstance, field: "status"))
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',63,['total':(remedyInstanceCount ?: 0)],-1)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',66,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443726967000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
