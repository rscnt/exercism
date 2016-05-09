(ns rna-transcription
  (:require [clojure.string :as str]))

;; Given a DNA strand, its transcribed RNA strand is formed by replacing each
;; nucleotide with its complement:
;;
;; G -> C
;; C -> G
;; T -> A
;; A -> U

;; Maps can be separated by white spaces or commas.
(defn to-rna [dna]
  (if (= dna (re-matches #"[GCTA]+" dna))
    (str/replace dna #"G|C|T|A" {"G" "C" "C" "G" "T" "A" "A" "U"})
    (throw (AssertionError. "it validates dna strands")) ))
