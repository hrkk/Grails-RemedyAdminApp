import remedyadminapp.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_remedyAdminApp_user_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: userInstance, field: 'username', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("user.username.label"),'default':("Username")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("username"),'required':(""),'value':(userInstance?.username)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'password', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("user.password.label"),'default':("Password")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("password"),'required':(""),'value':(userInstance?.password)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'profile', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("user.profile.label"),'default':("Profile")],-1)
printHtmlPart(6)
invokeTag('select','g',26,['id':("profile"),'name':("profile.id"),'from':(remedyadminapp.Profile.list()),'optionKey':("id"),'value':(userInstance?.profile?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'accountExpired', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("user.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',34,['name':("accountExpired"),'value':(userInstance?.accountExpired)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'accountLocked', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("user.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',42,['name':("accountLocked"),'value':(userInstance?.accountLocked)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'enabled', 'error'))
printHtmlPart(9)
invokeTag('message','g',47,['code':("user.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',50,['name':("enabled"),'value':(userInstance?.enabled)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'passwordExpired', 'error'))
printHtmlPart(10)
invokeTag('message','g',55,['code':("user.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',58,['name':("passwordExpired"),'value':(userInstance?.passwordExpired)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'remedies', 'error'))
printHtmlPart(11)
invokeTag('message','g',63,['code':("user.remedies.label"),'default':("Remedies")],-1)
printHtmlPart(12)
for( r in (userInstance?.remedies) ) {
printHtmlPart(13)
createTagBody(2, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',69,['controller':("remedy"),'action':("show"),'id':(r.id)],2)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'remedy.label', default: 'Remedy')]))
})
invokeTag('link','g',72,['controller':("remedy"),'action':("create"),'params':(['user.id': userInstance?.id])],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445541038000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
