(ns mgla.hello)

(defn create-user [first-name last-name]
    {:name first-name :last-name last-name})

(def user (create-user "Nikita" "Titov"))

(def player {:user user :id 10})
(def player2 {:user user :id 10})
