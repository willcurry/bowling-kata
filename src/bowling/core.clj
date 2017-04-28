(ns bowling.core)

(defn score [roles]
  (reduce + roles))
