(ns bowling.core-spec
  (:require [speclj.core :refer :all]
            [bowling.core :refer :all]))

(describe "bowling"
  (it "hitting the gutters gives 0 score"
    (should= 0 (score (repeat 20 0))))
  
  (it "scores all ones with twenties"
    (should= 20 (score (repeat 20 1)))))
