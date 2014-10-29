class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/" {
            controller = "movie"
            action = "listAll"
        }
        "500"(view: '/error')
    }
}
