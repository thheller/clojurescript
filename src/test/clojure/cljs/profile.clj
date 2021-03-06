(ns cljs.profile
  (:require [clojure.java.io :as io]
            [cljs.env :as env]
            [cljs.analyzer :as ana]
            [cljs.compiler :as comp]))

(comment

  ;; ~900ms
  (dotimes [_ 20]
    (time
      (ana/analyze-file (io/resource "cljs/core.cljs"))))

  ;; ~2700ms
  ;; after change ~2500
  (dotimes [_ 20]
    (time
      (env/with-compiler-env (env/default-compiler-env)
        (comp/compile-file (.getPath (io/resource "cljs/core.cljs")))
        (.delete (io/file "src/main/cljs/cljs/core.js")))))

  )