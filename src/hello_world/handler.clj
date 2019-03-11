(ns hello-world.handler
  (:require [compojure.core :refer :all]
            [selmer.parser :refer [render-file]]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
          (:gen-class))

(def skills [{:name "Node.JS" :percent "85"}
             {:name "Linux" :percent "75"}
             {:name "DevOps" :percent "65"}
             {:name "Scala" :percent "60"} 
             {:name "Criatividade" :percent "90"}
             {:name "Cloud" :percent "70"}
             {:name "League of Legends" :percent "80"}])

(defn get-document [params]
    (def skills (conj skills {:name (str (get params :skill_name)) :percent (str (get params :skill_percent))}))
    (println params)
    (println skills)
    "resposta")

(defroutes app-routes
  (GET "/" [] (render-file "public/index.html" {:skills skills }))
  (GET "/admin" [] (render-file "public/admin.html" {:skills skills }))
  (POST "/add/skill" request (get-document (get request :params) ) )
  (route/not-found "Not Found"))

(def app
  (wrap-defaults 
    app-routes 
    (assoc-in site-defaults [:security :anti-forgery] false)))

(defn -main
  [& [port]]
  (let [port (Integer. (or port
                           (System/getenv "PORT")
                           5000))]
    (jetty/run-jetty #'app {:port  port
                            :join? false})))
