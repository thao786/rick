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
	(GET "/index.html" [] (r/render "index.html"))
	(GET "/about.html" [] (r/render "about.html"))
	(GET "/press-controls.html" [] (r/render "press-controls.html"))
	(GET "/production-data-acquisition-scada.html" [] (r/render "production-data-acquisition-scada.html"))
	(GET "/automated-picking.html" [] (r/render "automated-picking.html"))
	(GET "/project.html" [] (r/render "project.html"))
	(GET "/remote-alarm.html" [] (r/render "remote-alarm.html"))
	(GET "/sr-ed.html" [] (r/render "sr-ed.html"))

	(GET "/owl-carousel/:file" [file] (io/resource (str "owl-carousel/" file)))
	(GET "/image/:file" [file] (io/resource (str "image/" file)))
	(GET "/menubar/:file" [file] (io/resource (str "menubar/" file)))
	(context "/slidersrc" []
		(GET "/:file" [file] (io/resource (str "slidersrc/" file)))
		(GET "/image/:file" [file] (io/resource (str "slidersrc/image/" file))))
	(context "/auto-pickup" []
		(GET "/:file" [file] (io/resource (str "auto-pickup/" file)))
		(GET "/photo/:file" [file] (io/resource (str "auto-pickup/photo/" file))))
	(GET "/csslow.css" [] (io/resource "csslow.css"))
	(GET "/csshi.css" [] (io/resource "csshi.css"))
	(route/not-found "Not Found"))

(def app
	(wrap-defaults app-routes site-defaults))



