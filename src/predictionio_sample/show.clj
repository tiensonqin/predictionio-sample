(ns predictionio-sample.show
  (:require [predictionio-sample.core :refer :all]))

(defn -main []
  "Pull recommends from prediction model"
  (prn (recommends {:pio_uid 1, :pio_n 20} "engine1")))
