(ns phone-cat.subs
  (:require [re-frame.core :refer [reg-sub subscribe]]))

(reg-sub
  :phones
  (fn [db]
    (:phones db)))
