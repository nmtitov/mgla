(ns mgla.math.simple-test
  (:require [clojure.test :refer :all]
            [mgla.math.simple :refer :all]))

(deftest sum-test
  (testing "FIXME, I fail."
    (let [a 1 b 2]
      (is (= (+ a b) (sum a b))))))
