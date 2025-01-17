(defproject org.squery/squery-mongojs "0.2.0-SNAPSHOT"
  :description "SQuery for the node.js mongodb driver"
  :url "https://github.com/tkaryadis/squery-mongojs"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [
                 [org.clojure/clojure "1.12.0"]
                 [org.clojure/clojurescript  "1.11.4"]   ;;for more new cljs i have json dep conflict, need data.json in core
                 [org.squery/squery-mongo-core "0.2.0-SNAPSHOT"]
                 [frankiesardo/linked "1.3.0"]
                 [cljs-bean "1.6.0"]]

  :cljsbuild {:builds [{:id           "squery-js"
                        :source-paths ["src"]
                        :compiler     {
                                       :output-to     "out/squery.js"
                                       :main          "squery-mongojs.examples.test"
                                       :target        :nodejs
                                       :optimizations  :none    ;:none ;;advanced
                                       :install-deps   true
                                       :npm-deps  {:mongodb "4.11.0"
                                                   "rxjs" "^7.8.1"}
                                       }}]}

  :plugins [[lein-cljsbuild "1.1.8"]
            [lein-npm "0.6.2" :hooks false ]
            [lein-codox "0.10.7"]]
            
  :codox {:language :clojurescript}
  )