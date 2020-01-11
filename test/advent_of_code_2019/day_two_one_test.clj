(ns advent-of-code-2019.day-two-one-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2019.day-two-one :refer :all]))

(deftest execute-simple-program
  (testing "a program that immediately halts"
    (is (= [99] (execute [99]))))

  (testing "1 + 1 = 2"
    (is (= [2,0,0,0,99] (execute [1,0,0,0,99]))))

  (testing "2 * 3 = 6"
    (is (= [2,3,0,6,99] (execute [2,3,0,3,99]))))

  (testing "multiply and store in a later position"
    (is (= [2,4,4,5,99,9801] (execute [2,4,4,5,99,0])))))

(deftest execute-multi-step-program
  (is (= [30,1,1,4,2,5,6,0,99] (execute [1,1,1,4,99,5,6,0,99]))))