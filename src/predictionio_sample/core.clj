(ns predictionio-sample.core
  (:require [clj-http.client :as client])
  (:use predictionio-sample.utils))

(defn user-create [user]
  "Add new user, params map must contains pio_uid"
  (client/post (url-for "users") (form-params user)))

(defn user-get [uid]
  "Get specified user"
  (client/get (url-for "users" uid) (query-params {})))

(defn user-delete [uid]
  "Delete specified user"
  (client/delete (url-for "users" uid) (query-params {})))

(defn item-create [item]
  "Add new item, params map must contains pio_iid and pio_itypes"
  (client/post (url-for "items") (form-params item)))

(defn item-get [iid]
  "Get specified item"
  (client/get (url-for "items" iid) (query-params {})))

(defn item-delete [iid]
  "Delete specified item"
  (client/delete (url-for "items" iid) (query-params {})))

(defn behavior-create [behavior]
  "Record user's action on item, params map must contains :pio_uid, :pio_iid and :pio_action"
  (client/post (url-for "actions/u2i") (form-params behavior)))

(defn recommends [user engine]
  "Get recommend items for specified user, params map must contains :pio_uid and :pio_n, subengine will be substitued with specified engine"
  (client/get (url-for (str "engines/itemrec/" engine "/topn")) (query-params user)))

(defn similars [item engine]
  "Get similar items for specified user, params map must contains :pio_iid and :pio_n, subengine will be substitued with specified engine"
  (client/get (url-for (str "engines/itemsim/" engine "/topn")) (query-params item)))
