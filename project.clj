(defproject hello-world "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :main hello-world.handler
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [hickory "0.7.1"]
                 [compojure "1.6.1"]
                 [selmer "1.12.5"]
                 [ring/ring-jetty-adapter "1.5.1"]
                 [ring/ring-defaults "0.3.2"]]
  :plugins [[lein-ring "0.12.4"]]
  :ring {:handler hello-world.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
