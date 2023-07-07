# VocaBoost - Analytics Server

VocabularyBoost (VocaBoost) helps you improve GRE and TOEFL vocabulary in an effective way.

- View VocaBoost official website on [here](https://www.vocabularyboost.com/).
- Install VocaBoost extension on [Chrome Web Store](https://chrome.google.com/webstore/detail/gre-vocabulary-highlighte/gfkmbmplhjdoejicgmaldndkcnnpplho).
- Install VocaBoost app on [App Store](https://apps.apple.com/app/vocabboost/id6447704480) or [Google Play Store](https://play.google.com/store/apps/details?id=vocaboost.com).

## 💻 Local setup

### MongoDB
- Install [MongoDB](https://www.mongodb.com/docs/manual/installation/#install-mongodb)

### Spring Boot
- Download [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
- Move JDK to correct path. e.g. `/Library/Java/JavaVirtualMachines/jdk-17.0.7.jdk`
- Set `JAVA_HOME` environment variable to e.g. `/Library/Java/JavaVirtualMachines/jdk-17.0.7.jdk/Contents/Home`
- Open IntelliJ -> File -> Project Structure -> Project Settings -> Project. Set Project SDK to JDK 17
- In IntelliJ, Preferences -> Build, Execution, Deployment -> Build Tools -> Gradle. At the bottom, set Gradle JVM to Project SDK 17

### Prometheus
- Download [Prometheus](https://prometheus.io/download/) and put the prometheus binary executable under the  `prometheus` folder
- Use `prometheus/prometheus.yml` in this repo as the config

### Node Exporter
- Download [Node Exporter](https://prometheus.io/download/#node_exporter)

### Grafana
- Create/sign in to your [Grafana](https://grafana.com/) account
- Generate an API key. Create a `.env` file in the root directory and store your username & API key
  ```
  GRAFANA_USERNAME=xxxxxxxx
  GRAFANA_API_KEY=xxxxxxxx
  ```
- Import `grafana/VocaBoost-1688184295940.json` as the dashboard

## 🏃🏻 Run

### MongoDB
- Start: `brew services start mongodb-community`
- Verify: `brew services list`
- Stop: `brew services stop mongodb-community`
- Restart (try when connection error): `brew services restart mongodb/brew/mongodb-community`

### Spring Boot
- Start: `./gradlew bootRun`
 
### Prometheus
- Start: `./prometheus/prometheus --config.file=prometheus.yml`
- Verify: `curl http://localhost:9090/metrics`
- Stop: `kill -9 $(ps aux | grep prometheus | grep -v 'grep' | awk '{print $2}')`

### Node Exporter
- Start: `./node_exporter`
