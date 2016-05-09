(ns bob
  (:require [clojure.string :as str]))

(defn response-for [told]
  (cond
    (= true (str/blank? told)) (str "Fine. Be that way!")
    (= told (re-matches #"^(?=.*[a-zA-Z])[A-Z0-9\s%$-/:-?{-~!\"^@#_`\[\]]{0,}$" told)) (str "Whoa, chill out!")
    (= told (re-matches #".*\?$" told)) (str "Sure.")
    :else (str "Whatever.")))
