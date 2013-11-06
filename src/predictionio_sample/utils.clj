(ns predictionio-sample.utils
  (:require [clojure.string :as string]))

(def app-key "gaEqLfrvzXwcy7NwlG7Ley5KCMNqvvyRWFGDv5YemQfxwU2H5nJgwQd87sGeSXg7")

(def api-url "http://127.0.0.1:8000/")

(defn build-params [m param-type]
  {param-type (if (contains? m :pio_appkey)
                  m
                  (assoc m :pio_appkey app-key))})

(defn form-params [m]
  (build-params m :form-params))

(defn query-params [m]
  (build-params m :query-params))

(defn url-for
  ([type] (str api-url type ".json"))
  ([type id] (str api-url type "/" id ".json")))
