(ns bowling.core)

(defn- spare? [rolls]
  (= 10 (apply + (take 2 rolls))))

(defn strike? [rolls]
  (= 10 (first rolls)))

(defn- rolls-to-score [rolls]
  (cond
    (spare? rolls) 3
    (strike? rolls) 3
    :else 2))

(defn- make-frames [rolls]
  (lazy-seq (cons (take (rolls-to-score rolls) rolls) (make-frames (drop 
    (if (strike? rolls) 1 2) rolls)))))

(defn- make-game [rolls]
  (take 10 (make-frames rolls)))

(defn- add-up [coll]
  (reduce + coll))

(defn score [rolls]
  (add-up 
    (map add-up (make-game rolls))))
