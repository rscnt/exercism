(ns word-count)

(defn word-collection
  ([thash hword]
   ()))

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
  (let [tHash {}]
    ([text] (map  (re-seq #"\w+" text)))))
