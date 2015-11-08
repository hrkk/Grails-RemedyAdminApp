grails.plugin.springsecurity.rejectIfNoRule = false
grails.plugin.springsecurity.fii.rejectPublicInvocations = true


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'dk.roninit.remedy.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'dk.roninit.remedy.UserRole'
grails.plugin.springsecurity.authority.className = 'dk.roninit.remedy.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/**':                ['permitAll'],
	'/error':           ['permitAll'],
    '/imageRest/**':    ['permitAll'],
	'/index':           ['permitAll'],
	'/index.gsp':       ['permitAll'],
	'/shutdown':        ['permitAll'],
	'/assets/**':       ['permitAll'],
	'/**/js/**':        ['permitAll'],
	'/**/css/**':       ['permitAll'],
	'/**/images/**':    ['permitAll'],
	'/**/favicon.ico':  ['permitAll']
]

grails.plugin.springsecurity.useBasicAuth = true
grails.plugin.springsecurity.basic.realmName = true

