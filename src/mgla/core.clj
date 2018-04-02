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

(defn handler [req]
  (ohs/with-channel req channel
                    (ohs/on-close channel (fn [status]
                                            (println "channel closed")))
                    (if (ohs/websocket? channel)
                      (println "Websocket channel")
                      (println "HTTP channel"))
                    (ohs/on-receive channel (fn [data]
                                              (ohs/send! channel data)))))

(defn start-server []
  (reset! server (ohs/run-server #'handler {:port 8080})))

(defn -main [& args]
  (start-server)
  (println "Server started on port 8080"))

(comment
  (start-server)
  (stop-server))
