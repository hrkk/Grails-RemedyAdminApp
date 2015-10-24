import remedyadminapp.Profile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_remedyAdminApp_profileshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/profile/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'profile.label', default: 'Profile'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',12,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',16,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',17,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',17,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',19,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',19,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',24,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (profileInstance?.fullName)) {
printHtmlPart(14)
invokeTag('message','g',33,['code':("profile.fullName.label"),'default':("Full Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',36,['bean':(profileInstance),'field':("fullName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (profileInstance?.email)) {
printHtmlPart(18)
invokeTag('message','g',44,['code':("profile.email.label"),'default':("Email")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',47,['bean':(profileInstance),'field':("email")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (profileInstance?.phoneNumber)) {
printHtmlPart(20)
invokeTag('message','g',55,['code':("profile.phoneNumber.label"),'default':("Phone Number")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',58,['bean':(profileInstance),'field':("phoneNumber")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (profileInstance?.areas)) {
printHtmlPart(22)
invokeTag('message','g',66,['code':("profile.areas.label"),'default':("Areas")],-1)
printHtmlPart(23)
for( a in (profileInstance.areas) ) {
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(a?.encodeAsHTML())
})
invokeTag('link','g',70,['controller':("area"),'action':("show"),'id':(a.id)],4)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(17)
if(true && (profileInstance?.machines)) {
printHtmlPart(27)
invokeTag('message','g',79,['code':("profile.machines.label"),'default':("Machines")],-1)
printHtmlPart(23)
for( m in (profileInstance.machines) ) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',84,['controller':("machine"),'action':("show"),'id':(m.id)],4)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(17)
if(true && (profileInstance?.user)) {
printHtmlPart(29)
invokeTag('message','g',93,['code':("profile.user.label"),'default':("User")],-1)
printHtmlPart(30)
createTagBody(3, {->
expressionOut.print(profileInstance?.user?.encodeAsHTML())
})
invokeTag('link','g',96,['controller':("user"),'action':("show"),'id':(profileInstance?.user?.id)],3)
printHtmlPart(16)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',105,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',105,['class':("edit"),'action':("edit"),'resource':(profileInstance)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',108,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',110,['url':([resource: profileInstance, action: 'delete']),'method':("DELETE")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',112,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445665577000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
