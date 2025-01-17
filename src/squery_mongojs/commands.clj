(ns squery-mongojs.commands
  (:require squery-mongo-core.operators.operators))

;;--------------------------------------read/write------------------------------------------------------------------------

(defmacro insert [command-coll-info documents & args]
  `(squery-mongojs.internal.convert.commands-run/run-command
     (squery-mongojs.internal.convert.commands/get-command-info ~command-coll-info)
     (apply squery-mongo-core.read-write/insert
            ~(vec (cons `(squery-mongojs.internal.convert.commands/get-db-namespace ~command-coll-info)
                        (cons documents args))))))

(defmacro dq [& args]
  `(let ~squery-mongo-core.operators.operators/operators-mappings
     (apply squery-mongo-core.read-write/dq-f ~(vec args))))

(defmacro delete [command-coll-info & args]
  `(squery-mongojs.internal.convert.commands-run/run-command
     (squery-mongojs.internal.convert.commands/get-command-info ~command-coll-info)
     (apply squery-mongo-core.read-write/delete ~(vec (cons `(squery-mongojs.internal.convert.commands/get-db-namespace ~command-coll-info) args)))))


(defmacro uq [& args]
  `(let ~squery-mongo-core.operators.operators/operators-mappings
     (apply squery-mongo-core.read-write/uq-f ~(vec args))))

(defmacro update- [command-coll-info & args]
  `(squery-mongojs.internal.convert.commands-run/run-command
     (squery-mongojs.internal.convert.commands/get-command-info ~command-coll-info)
     (apply squery-mongo-core.read-write/update- ~(vec (cons `(squery-mongojs.internal.convert.commands/get-db-namespace ~command-coll-info) args)))))

(defmacro find-and-modify [command-coll-info & args]
  `(squery-mongojs.internal.convert.commands-run/run-command
     (squery-mongojs.internal.convert.commands/get-command-info ~command-coll-info)
     (let ~squery-mongo-core.operators.operators/operators-mappings
       (apply squery-mongo-core.read-write/find-and-modify-f
              ~(vec (cons `(squery-mongojs.internal.convert.commands/get-db-namespace ~command-coll-info) args))))))

(defmacro q-count [command-coll-info & args]
  `(squery-mongojs.internal.convert.commands-run/run-command
     (squery-mongojs.internal.convert.commands/get-command-info ~command-coll-info)
     (let ~squery-mongo-core.operators.operators/operators-mappings
       (apply squery-mongo-core.read-write/q-count-f
              ~(vec (cons `(squery-mongojs.internal.convert.commands/get-db-namespace ~command-coll-info) args))))))

(defmacro q-distinct [command-coll-info & args]
  `(squery-mongojs.internal.convert.commands-run/run-command
     (squery-mongojs.internal.convert.commands/get-command-info ~command-coll-info)
     (let ~squery-mongo-core.operators.operators/operators-mappings
       (apply squery-mongo-core.read-write/q-distinct-f
              ~(vec (cons `(squery-mongojs.internal.convert.commands/get-db-namespace ~command-coll-info) args))))))

;;------------------------------------------read/write with driver method use-----------------------------------------

(defmacro q [command-coll-info & args]
  `(squery-mongojs.internal.convert.commands-run/run-aggregation
     (squery-mongojs.internal.convert.commands/get-command-info ~command-coll-info)
     (let ~squery-mongo-core.operators.operators/operators-mappings
       (apply squery-mongo-core.read-write/q-f
              ~(vec (cons `(squery-mongojs.internal.convert.commands/get-db-namespace ~command-coll-info) args))))))

(defmacro fq [command-coll-info & args]
  `(squery-mongojs.internal.convert.commands-run/run-find
     (squery-mongojs.internal.convert.commands/get-command-info ~command-coll-info)
     (let ~squery-mongo-core.operators.operators/operators-mappings
       (apply squery-mongo-core.read-write/fq-f ~(vec (cons `(squery-mongojs.internal.convert.commands/get-db-namespace ~command-coll-info) args))))))


;;-------------------------------------------admin-------------------------------------------------------------------

(defmacro drop-collection [command-coll-info & args]
  `(squery-mongojs.internal.convert.commands-run/run-command
     (squery-mongojs.internal.convert.commands/get-command-info ~command-coll-info)
     (let ~squery-mongo-core.operators.operators/operators-mappings
       (apply squery-mongo-core.administration/drop-collection
              ~(vec (cons `(squery-mongojs.internal.convert.commands/get-db-namespace ~command-coll-info) args))))))