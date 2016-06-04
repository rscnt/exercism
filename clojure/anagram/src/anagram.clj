(ns anagram
  (:require [clojure.data :as data])
  (:require [clojure.string :as str]))

(defn count-letter-in-word [word letter]
  (count (re-seq (re-pattern (str letter)) word)))

(defn build-hash-letter-count [word]
  (let [letter-map {}]
    (loop [letter word]
      (update letter-map letter
              (fn [oletter] (inc (get letter-map letter 0)))))))

(defn is-palindrome-of [word candidate]
  (cond
    (= (count candidate) (count word)) (= (take 2 (data/diff (build-hash-letter-count word) (build-hash-letter-count candidate))))
    :else false))

(defn anagrams-for [word list-candidates]
  (filter
   (fn [candidate]
     (is-palindrome-of word candidate))
   (remove #(= (first %) word) list-candidates)))
