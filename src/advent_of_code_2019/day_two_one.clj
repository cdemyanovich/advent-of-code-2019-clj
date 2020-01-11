(ns advent-of-code-2019.day-two-one
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]
            [clojure.string :as str]))

(def raw-program
  (->> "data/2-1.txt"
       io/resource
       slurp))

(defn parse-program
  [program]
  (vec
    (map edn/read-string
      (str/split program #","))))

(defn restore-program-to-state-before-fire
  [program]
  (-> program
      (assoc 1 12)
      (assoc 2 2)))


(defn execute
  [program]
  (loop [program program
         opcode-position 0]
    (let [opcode (nth program opcode-position)]
      (cond
        (= 99 opcode)
        program
        (= 1 opcode)
        (recur
          (assoc program
            (nth program (+ 3 opcode-position))
            (+ (nth program (nth program (+ 1 opcode-position)))
               (nth program (nth program (+ 2 opcode-position)))))
          (+ 4 opcode-position))
        (= 2 opcode)
        (recur
          (assoc program
            (nth program (+ 3 opcode-position))
            (* (nth program (nth program (+ 1 opcode-position)))
               (nth program (nth program (+ 2 opcode-position)))))
          (+ 4 opcode-position))))))

(comment
  ;; What value is left at position 0 after the program halts? Answer: 4138687.
  (->> raw-program
       parse-program
       restore-program-to-state-before-fire
       execute))