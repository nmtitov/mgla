(ns mgla.core
  (:require [org.httpkit.server :as ohs]))

(defn index [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello, W!"})

(defonce server (atom nil))

(defn stop-server []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))

(defn -main [& args]
  (reset! server (ohs/run-server #'index {:port 8080}))
  (println "Server started on port 8080"))
