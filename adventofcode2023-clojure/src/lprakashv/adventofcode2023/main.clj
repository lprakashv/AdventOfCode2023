(ns lprakashv.adventofcode2023.main
  (:gen-class)
  (:require [lprakashv.adventofcode2023.day1 :as day1]))

(defn greet
  "Callable entry point to the application."
  [data]
  (println (str "Hello, " (or (:name data) "World") "!")))

(def problems ["day1-1" "day1-2"])

(defn -main
  [& args]
  (case (first args)
    "day1-1"  (println (day1/calibration-sum-1))
    "day1-2"  (println (day1/calibration-sum-2))
    (println "all options: " problems)))
