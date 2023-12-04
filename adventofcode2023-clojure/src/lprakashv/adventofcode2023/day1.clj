(ns lprakashv.adventofcode2023.day1
  (:gen-class)
  (:require clojure.java.io
            [clojure.string :as s]))

(defn- positive-numbers
  ([] (positive-numbers 1))
  ([n] (lazy-seq (cons n (positive-numbers (inc n))))))

(defn- replace-worded-nums-to-digits [string]
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

(defn calibration-sum-1
  []
  (->> (slurp (.getFile (clojure.java.io/resource "day1_input.txt")))
       (s/split-lines)
       (map
        (fn [line]
          (->> (vec line)
               (filter #(Character/isDigit %))
               ((fn [char-list] [(first char-list) (last char-list)]))
               (apply str)
               (Integer/parseInt))))
       (reduce +)))

(defn calibration-sum-2
  []
  (->> (slurp (.getFile (clojure.java.io/resource "day1_input.txt")))
       (s/split-lines)
       (map
        (fn [line]
          (->> line
               (replace-worded-nums-to-digits)
               (vec)
               (filter #(Character/isDigit %))
               ((fn [char-list] [(first char-list) (last char-list)]))
               (apply str)
               (Integer/parseInt))))
       (reduce +)))