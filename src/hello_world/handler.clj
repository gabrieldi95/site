(ns hello-world.handler
  (:require [compojure.core :refer :all]
            [selmer.parser :refer [render-file]]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
          (:gen-class))


(defroutes app-routes
  (GET "/" [] (render-file "public/index.html" {:name "Gabriel Di Pardi Arruda"}))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defn -main
  [& [port]]
  (let [port (Integer. (or port
                           (System/getenv "PORT")
                           5000))]
    (jetty/run-jetty #'app {:port  port
                            :join? false})))
