(ns lprakashv.adventofcode2023.core.core
  (:gen-class)
  (:require [clojure.string :as s]))

(defn positive-numbers
  ([] (positive-numbers 1))
  ([n] (lazy-seq (cons n (positive-numbers (inc n))))))

(defn replace-worded-nums-to-digits [string]
  (-> string
      (s/replace #"zero" "z0o")
      (s/replace #"one" "o1e")
      (s/replace #"two" "t2o")
      (s/replace #"three" "t3e")
      (s/replace #"four" "f4r")
      (s/replace #"five" "f5e")
      (s/replace #"six" "s6x")
      (s/replace #"seven" "s7n")
      (s/replace #"eight" "e8t")
      (s/replace #"nine" "n9e")))