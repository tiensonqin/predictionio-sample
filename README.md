# predictionio-sample

A Clojure recommendation sample for predictionio

## Usage
### Install leiningen
[https://github.com/technomancy/leiningen](https://github.com/technomancy/leiningen)

git clone http://github.com/tiensonqin/predictionio-sample

cd predictionio-sample

lein repl

### Install PredictionIO
[http://docs.prediction.io/current/installation/index.html](http://docs.prediction.io/current/installation/index.html)

#### Add your App to PredictionIO
Go to the web admin panel of PredictionIO Server at http://<yourhost>:9000/. Follow on-screen instruction to add the first app. Now an app key can be obtained from the control panel. You need this key for clojure test.

#### Create a Prediction Engine
Next, you need to create a Prediction Engine under the new app. Each engine deals with one specific prediction problem. Let's start by creating an Item Recommendation Engine (itemrec) and name it engine1.

### Test
lein run -m predictionio-sample.import

Check Engine Status make sure its running. Please refer to [http://docs.prediction.io/current/tutorials/quickstart-php.html#check-engine-status](http://docs.prediction.io/current/tutorials/quickstart-php.html#check-engine-status)

lein run -m predictionio-sample.show
## License

Copyright © 2013 tiensonqin@gmail.com

Distributed under the Eclipse Public License, the same as Clojure.
