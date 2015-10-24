import remedyadminapp.UserCmd
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_remedyAdminApp_user_registerProfileForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/_registerProfileForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: profileInstance, field: 'fullName', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("profile.fullName.label"),'default':("Full Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("fullName"),'required':(""),'value':(profileInstance?.fullName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: profileInstance, field: 'email', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("profile.email.label"),'default':("Email")],-1)
printHtmlPart(5)
invokeTag('textField','g',18,['name':("email"),'value':(profileInstance?.email)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: profileInstance, field: 'phoneNumber', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("profile.phoneNumber.label"),'default':("Phone Number")],-1)
printHtmlPart(5)
invokeTag('textField','g',26,['name':("phoneNumber"),'value':(profileInstance?.phoneNumber)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445667322000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
