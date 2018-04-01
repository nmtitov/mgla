(ns mgla.core
  (:require [org.httpkit.server :as ohs]))

(defn index [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello, World!"})

(defn -main [& args]
  (ohs/run-server #'index {:port 8080})
  (println "Server started on port 8080"))

(comment
  (-main))