(ns anagram
  (:require [clojure.string :as str]))

(defn is-palindrome-of [word candidate] ())

(defn anagram-for [word list-candidates]
  (filter (fn [candidate] (is-palindrome-of word candidate)) list-candidates))
