class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/api/faces"(resource: "faceRest")

        "/register"{
            controller = "user"
            action = "register"
        }

        "/"(view:"/index")
        "500"(view:'/error')

      //
	}
}
