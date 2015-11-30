(ns com.mowforth.hystrix.reporter
  "Hystrix reporter which echoes data to a log at a fixed interval."
  (:require [clojure.tools.logging :as log])
  (:import [com.netflix.hystrix.contrib.metrics.eventstream
            HystrixMetricsPoller
            HystrixMetricsPoller$MetricsAsJsonPollerListener])
  (:gen-class
   :name "com.mowforth.hystrix.reporter.LogentriesReporter"
   :implements [io.dropwizard.lifecycle.Managed]
   :init gen-poller
   :main false
   :state state))

(defn -gen-poller []
  (let [frequency 5000 ; just hard-code the polling frequency to 5 seconds for brevity
        listener (reify HystrixMetricsPoller$MetricsAsJsonPollerListener
                   (handleJsonMetric [this json] (log/info json)))]
    (HystrixMetricsPoller. listener frequency)))

(defn -start [this] (.start (.state this)))
(defn -stop [this] (.shutdown (.state this)))
