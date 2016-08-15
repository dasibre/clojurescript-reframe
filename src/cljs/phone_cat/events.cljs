(ns phone-cat.events
 (:require
    [phone-cat.db    :refer [default-db]]
    [re-frame.core :refer [reg-event path trim-v after debug]]))


(reg-event
  :initialize-db
  (fn []
    default-db))

(reg-event
  :add-phone
  (fn [db [_ my-phone]]
    (println db)
   (conj (:phones db) my-phone)))
