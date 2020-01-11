(ns advent-of-code-2019.day-one-one
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]))

(def input
  (->> "data/1-1.txt"
       io/resource
       io/reader
       line-seq))

(def masses
  (map edn/read-string input))

(defn fuel-needed
  "Fuel required to launch a given module is based on its mass. Specifically, to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2."
  [mass]
  (-> mass
      (/ 3)
      Math/floor
      (- 2)
      int))

(defn total-fuel-needed
  "Sums the fuel needed for all of the given masses"
  [masses]
  (if (empty? masses)
    0
    (->> masses
         (map fuel-needed)
         (reduce +))))