(ns hello-world.handler
  (:require [compojure.core :refer :all]
            [selmer.parser :refer [render-file]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))


(defroutes app-routes
  (GET "/" [] (render-file "public/index.html" {:name "John"}))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
