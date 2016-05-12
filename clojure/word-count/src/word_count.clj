(ns word-count
  (:require [clojure.string :as str]))

(defn sub-ocurrences-in-string ([string sub] (count (re-seq (re-pattern (str "\\b" sub "\\b")) string))))

;; A B C C C D A B
;; -- {A 1}
;; -- {A 1 B 1}
;; -- {A 1 B 1 C 1}
;; -- {A 1 B 1 C 2}
;; -- {A 1 B 1 C 3}
;; -- {A 1 B 1 C 3 D 1}
;; -- {A 2 B 1 C 3 D 1}
;; -- {A 2 B 2 C 3 D 1}

(defn word-count
  ([text]
   (defn sub-counter [sub] (sub-ocurrences-in-string (str/lower-case text) (str/lower-case sub)))
   (let [word-list (re-seq #"\w+" (str/lower-case text)) words-map {}]
     (apply merge (map (fn [word] (update words-map word (fn [old-word] (sub-counter word)))) word-list)))))
