(ns predictionio-sample.import
  (:require [predictionio-sample.core :refer :all]))

(defn -main []
  "Import users, items and the behaviors"
  ;; add 10 users
  (dorun (map #(user-create {:pio_uid %}) (range 1 11)))
  ;; add 50 items
  (dorun (map #(item-create {:pio_iid %, :pio_itypes "post"}) (range 1 51)))
  ;; add behaviors, each user randomly views 10 items
  (for [i (range 1 11)]
    (map #(behavior-create {:pio_uid i, :pio_iid %, :pio_action "view"}) (take 10 (distinct (filter (comp not zero?) (take 100 (repeatedly #(rand-int 50)))))))))
