(ns rick.handler
	(:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [sodahead.render :as r]
            [rick.lib :as l]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
	(GET "/" [] (r/render "index.html"))
;	(GET "/" [] (r/render ""))
	(GET "/about.html" [] (r/render "about.html"))
	(GET "/press-controls.html" [] (r/render "press-controls.html"))
	(GET "/production-data-aquisition.html" [] (r/render "production-data-aquisition.html"))
	(GET "/automated-warehouse-picking.html" [] (r/render "automated-warehouse-picking.html"))
	(GET "/project.html" [] (r/render "project.html"))


	(GET "/image/:file" [file] (io/resource (str "image/" file)))
	(GET "/menubar/:file" [file] (io/resource (str "menubar/" file)))
	(context "/slidersrc" []
		(GET "/:file" [file] (io/resource (str "slidersrc/" file)))
		(GET "/image/:file" [file] (io/resource (str "slidersrc/image/" file))))
	(GET "/csslow.css" [] (io/resource "csslow.css"))
	(GET "/csshi.css" [] (io/resource "csshi.css"))
	(route/not-found "Not Found"))

(def app
	(wrap-defaults app-routes site-defaults))


